package org.sakhnyasha.repository;

import org.sakhnyasha.model.Hotel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HotelRepository {
    private static List<Hotel> hotelList = new ArrayList<>();


    public void addHotel(Hotel hotel){
        hotelList.add(hotel);
    }

    public Hotel getHotel(String name){
        return hotelList.stream().filter(hotel -> hotel.getName().equals(name)).findAny().orElse(null);
    }

    public List<Hotel> getAllHotels(){
        return hotelList;
    }
}
