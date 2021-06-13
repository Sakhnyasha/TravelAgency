package org.sakhnyasha.repository;

import org.sakhnyasha.model.HotelModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HotelRepository {
    private static List<HotelModel> hotelList = new ArrayList<>();


    public void addHotel(HotelModel hotel){
        hotelList.add(hotel);
    }

    public HotelModel getHotel(String name){
        return hotelList.stream().filter(hotel -> hotel.getName().equals(name)).findAny().orElse(null);
    }

    public List<HotelModel> getAllHotels(){
        return hotelList;
    }
}
