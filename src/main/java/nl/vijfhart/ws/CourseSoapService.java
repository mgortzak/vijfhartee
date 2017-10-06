package nl.vijfhart.ws;

import nl.vijfhart.controller.CourseController;
import nl.vijfhart.model.Course;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService(serviceName = "CourseSoap")
public class CourseSoapService {
    @EJB
    private CourseController courseController;

    public List<Course> fetchCourses() {
        return courseController.findAll();
    }

    public Course addCourse(@WebParam(name = "course") Course course) {
        return courseController.insert(course);
    }
}
