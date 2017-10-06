package nl.vijfhart.ws;

import nl.vijfhart.dao.CourseDao;
import nl.vijfhart.model.Category;
import nl.vijfhart.model.Course;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@Stateless
@WebService(serviceName = "CourseSoap")
public class CourseSoapService {
    @EJB
    private CourseDao courseDao;

    public List<Course> fetchCourses() {

        List<Course> courses = courseDao.findAll();
        for (Course course : courses) {
            for (Category category : course.getCategories()) {
                category.setCourses(new ArrayList<>());
            }
        }
        return courses;
    }
}
