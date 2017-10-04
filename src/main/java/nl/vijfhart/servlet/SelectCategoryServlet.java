package nl.vijfhart.servlet;

import nl.vijfhart.dao.CategoryDao;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/categories")
public class SelectCategoryServlet extends HttpServlet {
    @EJB
    private CategoryDao categoryDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categoryList", categoryDao.findAll());
        request.getRequestDispatcher("categories.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("category", categoryDao.find(Long.parseLong(request.getParameter("id"))));
        request.getRequestDispatcher("category.jsp").forward(request, response);
    }
}
