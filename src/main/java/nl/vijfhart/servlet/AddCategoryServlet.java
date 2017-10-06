package nl.vijfhart.servlet;

import nl.vijfhart.controller.CategoryController;
import nl.vijfhart.model.Category;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add_category")
public class AddCategoryServlet extends HttpServlet {

    @EJB
    private CategoryController categoryController;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add_category.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category = new Category();
        category.setName(request.getParameter("name"));
        category.setDescription(request.getParameter("description"));

        categoryController.insert(category);

        request.setAttribute("category", category);
        request.getRequestDispatcher("category.jsp").forward(request, response);
    }
}
