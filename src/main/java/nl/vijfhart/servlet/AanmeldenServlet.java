package nl.vijfhart.servlet;

import nl.vijfhart.model.Aanmelding;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/aanmelden")
public class AanmeldenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("aanmelding.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Aanmelding aanmelding = new Aanmelding();
        aanmelding.setVoornaam(request.getParameter("voornaam"));
        aanmelding.setAchternaam(request.getParameter("achternaam"));
        aanmelding.setEmail(request.getParameter("email"));
        aanmelding.setGeboortedatum(LocalDate.parse(request.getParameter("geboortedatum")));
        aanmelding.setGeboorteplaats(request.getParameter("geboorteplaats"));

        request.setAttribute("aanmelding", aanmelding);
        request.getRequestDispatcher("aanmelding.jsp").forward(request, response);
    }
}
