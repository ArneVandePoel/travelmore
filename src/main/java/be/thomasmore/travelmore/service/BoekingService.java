package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.repository.BoekingRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BoekingService {
    @Inject
    private BoekingRepository boekingRepository;

    public List<Boeking> findByGebruiker(int gebruikerID) {return boekingRepository.findByGebruiker(gebruikerID);}

    public Boeking findBoeking(int id){return boekingRepository.findById(id);}

    public void update(Boeking boeking){boekingRepository.update(boeking);}

    public void insert(Boeking boeking){boekingRepository.insert(boeking);}
}
