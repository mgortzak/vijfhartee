package nl.vijfhart.mb;

import nl.vijfhart.controller.CategoryController;
import nl.vijfhart.model.Category;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class CategoryBean {
    @EJB
    private CategoryController categoryController;

    public List<Category> getCategories() {
        return categoryController.findAll();
    }
}
