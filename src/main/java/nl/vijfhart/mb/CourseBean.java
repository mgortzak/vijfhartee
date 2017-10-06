package nl.vijfhart.mb;

import nl.vijfhart.model.Course;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class CourseBean {

    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();

        Course foo = new Course();
        foo.setName("foo");
        foo.setDescription("foo! :-(");
        foo.setDuration(5);
        foo.setPrice(500);

        Course bar = new Course();
        bar.setName("bar");
        bar.setDescription("bar! :-(");
        bar.setDuration(3);
        bar.setPrice(600);

        courses.add(foo);
        courses.add(bar);

        return courses;
    }
}
