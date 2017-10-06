package nl.vijfhart.rs;

import nl.vijfhart.dao.CourseDao;
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
@Path("/course")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseRsService {
    @EJB
    private CourseDao courseDao;

    @GET
    public List<Course> fetchCourses() {

        List<Course> courses = courseDao.findAll();
        for (Course course : courses) {
            for (Category category : course.getCategories()) {
                category.setCourses(new ArrayList<>());
            }
        }
        return courses;
    }

    @POST
    public Course addCourse(@WebParam(name = "course") Course course) {
        courseDao.insert(course);

        return course;
    }

}
