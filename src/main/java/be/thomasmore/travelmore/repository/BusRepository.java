package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Bus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BusRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Bus findById(int id) {return entityManager.find(Bus.class, id);}

    public void insert(Bus bus){entityManager.persist(bus);}
}
