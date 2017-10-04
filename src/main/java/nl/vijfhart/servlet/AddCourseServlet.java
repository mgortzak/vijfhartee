package nl.vijfhart.servlet;

import nl.vijfhart.dao.CourseDao;
import nl.vijfhart.model.Course;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add_course")
public class AddCourseServlet extends HttpServlet {

    @EJB
    private CourseDao courseDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add_course.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Course course = new Course();
        course.setName(request.getParameter("name"));
        course.setDescription(request.getParameter("description"));
        course.setDuration(Integer.parseInt(request.getParameter("duration")));
        course.setPrice(Integer.parseInt(request.getParameter("price")));

        courseDao.insert(course);

        request.setAttribute("course", course);
        request.getRequestDispatcher("course.jsp").forward(request, response);
    }
}
