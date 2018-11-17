package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.domain.Gebruiker;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class BoekingRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Boeking findById(int id) {return entityManager.find(Boeking.class, id);}

    public List<Boeking> findByGebruiker(int gebruikerID){
        Gebruiker gebruiker = entityManager.find(Gebruiker.class, gebruikerID);

        Query q = entityManager.createNamedQuery(Boeking.FIND_BOEKINGEN_GEBRUIKER, Boeking.class);
        q.setParameter("gebruiker", gebruiker);

        return q.getResultList();
    }

    public void update(Boeking boeking) { entityManager.merge(boeking);}

    public void insert(Boeking boeking) { entityManager.persist(boeking);}
}
