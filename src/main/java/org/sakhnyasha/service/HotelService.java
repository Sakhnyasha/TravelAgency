package org.sakhnyasha.service;

import org.sakhnyasha.model.HotelModel;
import org.sakhnyasha.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public void addHotel(HotelModel hotel){
        hotelRepository.addHotel(hotel);
    }

    public HotelModel getHotel(String name){
        return hotelRepository.getHotel(name);
    }

    public List<HotelModel> getAllHotels(){
        return hotelRepository.getAllHotels();
    }
}
