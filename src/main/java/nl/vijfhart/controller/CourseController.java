package nl.vijfhart.controller;

import nl.vijfhart.dao.CourseDao;
import nl.vijfhart.model.Category;
import nl.vijfhart.model.Course;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CourseController {
    @EJB
    private CourseDao courseDao;

    public List<Course> findAll() {
        List<Course> courses = courseDao.findAll();
        for (Course course : courses) {
            for (Category category : course.getCategories()) {
                category.setCourses(new ArrayList<>());
            }
        }
        return courses;
    }

    public Course insert(Course course) {
        courseDao.insert(course);

        return course;
    }

    public Course find(int id) {
        return courseDao.find(id);
    }
}
