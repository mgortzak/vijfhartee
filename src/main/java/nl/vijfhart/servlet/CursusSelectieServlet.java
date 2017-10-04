package nl.vijfhart.servlet;

import nl.vijfhart.dao.CursusDao;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(value = "/cursussen", loadOnStartup = 1)
public class CursusSelectieServlet extends HttpServlet {
    @Resource(name = "jdbc/vijfhartds")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("courseList", CursusDao.INSTANCE.findAll(dataSource));
        request.getRequestDispatcher("cursussen.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cursus", CursusDao.INSTANCE.get(dataSource, Integer.parseInt(request.getParameter("selectedCourse"))));
        request.getRequestDispatcher("cursus.jsp").forward(request, response);
    }
}
