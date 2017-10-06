package nl.vijfhart.mb;

import nl.vijfhart.controller.CourseController;
import nl.vijfhart.model.Course;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class CourseBean {
    @EJB
    private CourseController courseController;

    public List<Course> getCourses() {
        return courseController.findAll();
    }
}
