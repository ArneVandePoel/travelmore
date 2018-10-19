package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.GebruikersType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GebruikersTypeRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public GebruikersType findById(int id){return entityManager.find(GebruikersType.class, id);}

    public void insert(GebruikersType gebruikersType) {entityManager.persist(gebruikersType);}
}
