package nl.vijfhart.ws;

import nl.vijfhart.controller.CategoryController;
import nl.vijfhart.model.Category;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService(serviceName = "CategorySoap")
public class CategorySoapService {
    @EJB
    private CategoryController categoryController;

    public List<Category> fetchCategories() {
        return categoryController.findAll();
    }

    public Category addCategory(@WebParam(name = "category") Category category) {
        return categoryController.insert(category);
    }
}
