package nl.vijfhart.ws;

import nl.vijfhart.dao.CourseDao;
import nl.vijfhart.model.Course;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@Stateless
@WebService(serviceName = "MyCourses")
public class CourseSoapService {
    @EJB
    private CourseDao courseDao;

    public List<Course> fetchCourses() {
        Course course = new Course();
        course.setName("foo");
        course.setDescription("bar");

        List<Course> list = new ArrayList<>();
        list.add(course);

        return list;
//        return courseDao.findAll();
    }
}
