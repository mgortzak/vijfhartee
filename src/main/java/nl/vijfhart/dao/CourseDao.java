package nl.vijfhart.dao;

import nl.vijfhart.model.Course;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class CourseDao {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Course> findAll() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
        Root<Course> courseRoot = criteriaQuery.from(Course.class);
        criteriaQuery.select(courseRoot);
        criteriaQuery.orderBy(criteriaBuilder.asc(courseRoot.get(courseRoot.getModel().getSingularAttribute("description"))));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public void insert(Course course) {
        entityManager.persist(course);
    }


    public Course find(int id) {
        return entityManager.find(Course.class, id);
    }
}
