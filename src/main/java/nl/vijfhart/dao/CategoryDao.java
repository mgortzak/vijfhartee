package nl.vijfhart.dao;

import nl.vijfhart.model.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Category> findAll() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Category> criteriaQuery = criteriaBuilder.createQuery(Category.class);
        Root<Category> categorieRoot = criteriaQuery.from(Category.class);
        criteriaQuery.select(categorieRoot);
        criteriaQuery.orderBy(criteriaBuilder.asc(categorieRoot.get(categorieRoot.getModel().getSingularAttribute("description"))));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public void insert(Category category) {
        entityManager.merge(category);
    }


    public Category find(long id) {
        return entityManager.find(Category.class, id);
    }
}
