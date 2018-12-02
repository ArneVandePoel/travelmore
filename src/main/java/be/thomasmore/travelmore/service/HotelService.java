package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Hotel;
import be.thomasmore.travelmore.repository.HotelRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class HotelService {
    @Inject
    private HotelRepository hotelRepository;
}
