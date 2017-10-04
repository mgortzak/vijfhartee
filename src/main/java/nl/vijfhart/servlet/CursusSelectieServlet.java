package nl.vijfhart.servlet;

import nl.vijfhart.dao.CursusDao;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/cursussen", loadOnStartup = 1)
public class CursusSelectieServlet extends HttpServlet {
    @EJB
    private CursusDao cursusDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("courseList", cursusDao.findAll());
        request.getRequestDispatcher("cursussen.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cursus", cursusDao.find(Integer.parseInt(request.getParameter("selectedCourse"))));
        request.getRequestDispatcher("cursus.jsp").forward(request, response);
    }
}
