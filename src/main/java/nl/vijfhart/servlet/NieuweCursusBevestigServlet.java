package nl.vijfhart.servlet;

import nl.vijfhart.dao.CursusDao;
import nl.vijfhart.model.Cursus;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/nieuwe_cursus_bevestig")
public class NieuweCursusBevestigServlet extends HttpServlet {

    @EJB
    private CursusDao cursusDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("nieuwe_cursus.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cursus cursus = new Cursus();
        cursus.setNaam(request.getParameter("naam"));
        cursus.setOmschrijving(request.getParameter("omschrijving"));
        cursus.setDuur(Integer.parseInt(request.getParameter("duur")));
        cursus.setPrijs(Integer.parseInt(request.getParameter("prijs")));

        cursusDao.insert(cursus);

        request.setAttribute("cursus", cursus);
        request.getRequestDispatcher("cursus.jsp").forward(request, response);
    }
}
