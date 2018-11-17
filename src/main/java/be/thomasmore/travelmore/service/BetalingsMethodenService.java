package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.BetalingsMethoden;
import be.thomasmore.travelmore.repository.BetalingsMethodenRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BetalingsMethodenService {
    @Inject
    private BetalingsMethodenRepository betalingsMethodenRepository;

    public BetalingsMethoden findBetalingsMethode(int id){return betalingsMethodenRepository.findById(id);}

    public List<BetalingsMethoden> findAll(){return betalingsMethodenRepository.findAll();}
}
