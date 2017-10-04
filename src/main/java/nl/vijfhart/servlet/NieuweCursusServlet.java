package nl.vijfhart.servlet;

import nl.vijfhart.model.Cursus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/nieuwe_cursus")
public class NieuweCursusServlet extends HttpServlet {

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

        request.setAttribute("cursus", cursus);
        request.getRequestDispatcher("nieuwe_cursus_bevestig.jsp").forward(request, response);
    }
}
