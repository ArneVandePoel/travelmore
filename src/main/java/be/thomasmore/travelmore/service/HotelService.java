package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.repository.HotelRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class HotelService {
    @Inject
    private HotelRepository hotelRepository;
}
