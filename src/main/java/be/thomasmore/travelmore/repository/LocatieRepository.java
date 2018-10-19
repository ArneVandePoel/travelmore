package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Locatie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class LocatieRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Locatie findByid(int id){return entityManager.find(Locatie.class, id);}

    public void insert(Locatie locatie){entityManager.persist(locatie);}
}
