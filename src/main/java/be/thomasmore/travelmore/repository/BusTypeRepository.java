package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.BusType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BusTypeRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public BusType findById(int id) {return entityManager.find(BusType.class, id);}

    public void insert(BusType busType){entityManager.persist(busType);}
}
