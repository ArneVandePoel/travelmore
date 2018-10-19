package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Reis;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ReisRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Reis findById(int id){return entityManager.find(Reis.class, id);}

    public void insert(Reis reis){entityManager.persist(reis);}
}
