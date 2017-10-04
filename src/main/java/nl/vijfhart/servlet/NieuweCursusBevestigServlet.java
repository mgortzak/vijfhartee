package nl.vijfhart.servlet;

import nl.vijfhart.dao.CursusDao;
import nl.vijfhart.model.Cursus;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/nieuwe_cursus_bevestig")
public class NieuweCursusBevestigServlet extends HttpServlet {

    @Resource(name = "jdbc/vijfhartds")
    private DataSource dataSource;

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

        int id = CursusDao.INSTANCE.insert(dataSource, cursus);
        System.out.println("id = " + id);
        if (id >= 0) {
            request.setAttribute("cursus", CursusDao.INSTANCE.get(dataSource, id));
        }

        request.getRequestDispatcher("cursus.jsp").forward(request, response);
    }

}
