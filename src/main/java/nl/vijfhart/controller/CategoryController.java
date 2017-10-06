package nl.vijfhart.controller;

import nl.vijfhart.dao.CategoryDao;
import nl.vijfhart.model.Category;
import nl.vijfhart.model.Course;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CategoryController {
    @EJB
    private CategoryDao categoryDao;

    public List<Category> findAll() {
        List<Category> categories = categoryDao.findAll();
        for (Category category : categories) {
            for (Course course : category.getCourses()) {
                course.setCategories(new ArrayList<>());
            }
        }
        return categories;
    }

    public Category insert(Category category) {
        categoryDao.insert(category);

        return category;
    }

    public Category find(long id) {
        return categoryDao.find(id);
    }

    public Category create(String name, String description) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);

        return category;
    }
}
