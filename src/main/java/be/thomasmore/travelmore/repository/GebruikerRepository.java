package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Gebruiker;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class GebruikerRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Gebruiker findById(int id){return entityManager.find(Gebruiker.class, id);}

    public Gebruiker findByEmail(String email){
        Query q = entityManager.createNamedQuery(Gebruiker.FIND_MAIL, Gebruiker.class);
        q.setParameter("email", email);
        List<Gebruiker> resultaat = q.getResultList();
        return resultaat.get(0);
    }

    public void insert(Gebruiker gebruiker){entityManager.persist(gebruiker);}
}
