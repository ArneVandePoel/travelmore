package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Hotel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class HotelRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Hotel findById(int id){return entityManager.find(Hotel.class, id);}

    public void insert(Hotel hotel){entityManager.persist(hotel);}
}
