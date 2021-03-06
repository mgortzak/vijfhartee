package nl.vijfhart.servlet;

import nl.vijfhart.controller.CourseController;
import nl.vijfhart.dao.CategoryDao;
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
    private CourseController courseController;

    @EJB
    private CategoryDao categoryDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add_course.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Course course = courseController.create(
                request.getParameter("name"),
                request.getParameter("description"),
                Integer.parseInt(request.getParameter("duration")),
                Integer.parseInt(request.getParameter("price"))
        );

        course.getCategories().add(categoryDao.find(101L));
        course.getCategories().add(categoryDao.find(202L));

        courseController.insert(course);

        request.setAttribute("course", course);
        request.getRequestDispatcher("course.jsp").forward(request, response);
    }
}
