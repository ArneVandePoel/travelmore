package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Boeking;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BoekingRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Boeking findById(int id) {return entityManager.find(Boeking.class, id);}

    public void insert(Boeking boeking) { entityManager.persist(boeking);}
}
