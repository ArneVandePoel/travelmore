package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.repository.GebruikerRepository;

import javax.inject.Inject;

public class GebruikerService {
    @Inject
    private GebruikerRepository gebruikerRepository;

    public void insert(Gebruiker gebruiker) {gebruikerRepository.insert(gebruiker);}
}
