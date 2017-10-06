package nl.vijfhart.ws;

import nl.vijfhart.dao.CategoryDao;
import nl.vijfhart.model.Category;
import nl.vijfhart.model.Course;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@Stateless
@WebService(serviceName = "CategorySoap")
public class CategorySoapService {
    @EJB
    private CategoryDao categoryDao;

    public List<Category> fetchCategories() {

        List<Category> categories = categoryDao.findAll();
        for (Category category : categories) {
            for (Course course : category.getCourses()) {
                course.setCategories(new ArrayList<>());
            }
        }
        return categories;
    }

    public Category addCategory(@WebParam(name = "category") Category category) {
        categoryDao.insert(category);

        return category;
    }
}
