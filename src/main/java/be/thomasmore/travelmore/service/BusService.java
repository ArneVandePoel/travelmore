package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.repository.BusRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class BusService {
    @Inject
    private BusRepository busRepository;
}
