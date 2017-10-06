package nl.vijfhart.rs;

import nl.vijfhart.dao.CategoryDao;
import nl.vijfhart.model.Category;
import nl.vijfhart.model.Course;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryRsService {
    @EJB
    private CategoryDao categoryDao;

    @GET
    public List<Category> fetchCategories() {

        List<Category> categories = categoryDao.findAll();
        for (Category category : categories) {
            for (Course course : category.getCourses()) {
                course.setCategories(new ArrayList<>());
            }
        }
        return categories;
    }

    @POST
    public Category addCategory(@WebParam(name = "category") Category category) {
        categoryDao.insert(category);

        return category;
    }
}
