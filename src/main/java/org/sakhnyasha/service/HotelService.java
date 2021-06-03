package org.sakhnyasha.service;

import org.sakhnyasha.model.Hotel;
import org.sakhnyasha.model.User;
import org.sakhnyasha.repository.HotelRepository;
import org.sakhnyasha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public void addHotel(Hotel hotel){
        hotelRepository.addHotel(hotel);
    }

    public Hotel getHotel(String name){
        return hotelRepository.getHotel(name);
    }

    public List<Hotel> getAllHotels(){
        return hotelRepository.getAllHotels();
    }
}
