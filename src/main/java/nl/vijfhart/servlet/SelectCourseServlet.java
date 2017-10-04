package nl.vijfhart.servlet;

import nl.vijfhart.dao.CourseDao;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/courses")
public class SelectCourseServlet extends HttpServlet {
    @EJB
    private CourseDao courseDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("courseList", courseDao.findAll());
        request.getRequestDispatcher("courses.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("course", courseDao.find(Integer.parseInt(request.getParameter("id"))));
        request.getRequestDispatcher("course.jsp").forward(request, response);
    }
}
