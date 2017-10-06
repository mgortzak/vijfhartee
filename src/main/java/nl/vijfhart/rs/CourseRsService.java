package nl.vijfhart.rs;

import nl.vijfhart.controller.CourseController;
import nl.vijfhart.model.Course;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("/course")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseRsService {
    @EJB
    private CourseController courseController;


    @GET
    public List<Course> fetchCourses() {
        return courseController.findAll();
    }

    @POST
    public Course addCourse(@WebParam(name = "course") Course course) {
        return courseController.insert(course);
    }
}
