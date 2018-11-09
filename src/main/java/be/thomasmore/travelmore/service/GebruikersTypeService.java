package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.GebruikersType;
import be.thomasmore.travelmore.repository.GebruikersTypeRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GebruikersTypeService {
    @Inject
    private GebruikersTypeRepository gebruikersTypeRepository;

    public GebruikersType findGebruikersTypeByID(int id) {
        return gebruikersTypeRepository.findById(id);
    }
}
