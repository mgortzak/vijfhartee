package nl.vijfhart.rs;

import nl.vijfhart.controller.CategoryController;
import nl.vijfhart.model.Category;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryRsService {
    @EJB
    private CategoryController categoryController;

    @GET
    public List<Category> fetchCategories() {
        return categoryController.findAll();
    }

    @POST
    public Category addCategory(@WebParam(name = "category") Category category) {
        return categoryController.insert(category);
    }
}
