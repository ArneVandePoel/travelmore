package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.BetalingsMethoden;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BetalingsMethodenRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public BetalingsMethoden findById(int id) { return entityManager.find(BetalingsMethoden.class, id);}

    public List<BetalingsMethoden> findAll(){
        return entityManager.createNamedQuery(BetalingsMethoden.FIND_ALL, BetalingsMethoden.class).getResultList();
    }

    public void insert(BetalingsMethoden betalingsMethode) { entityManager.persist(betalingsMethode);}
}
