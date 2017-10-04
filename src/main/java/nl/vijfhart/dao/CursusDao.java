package nl.vijfhart.dao;

import nl.vijfhart.model.Cursus;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class CursusDao {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Cursus> findAll() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cursus> criteriaQuery = criteriaBuilder.createQuery(Cursus.class);
        Root<Cursus> cursusRoot = criteriaQuery.from(Cursus.class);
        criteriaQuery.select(cursusRoot);
        criteriaQuery.orderBy(criteriaBuilder.asc(cursusRoot.get(cursusRoot.getModel().getSingularAttribute("naam"))));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public void insert(Cursus cursus) {
        entityManager.persist(cursus);
    }


    public Cursus find(int id) {
        return entityManager.find(Cursus.class, id);
    }
}
