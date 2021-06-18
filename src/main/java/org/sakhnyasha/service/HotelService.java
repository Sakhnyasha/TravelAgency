package org.sakhnyasha.service;

import org.sakhnyasha.entity.City;
import org.sakhnyasha.entity.Hotel;
import org.sakhnyasha.entity.Room;
import org.sakhnyasha.model.HotelModel;
import org.sakhnyasha.repository.CityRepository;
import org.sakhnyasha.repository.HotelRepository;
import org.sakhnyasha.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HotelService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private CityRepository cityRepository;


    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public void deleteHotel(Long hotelId) {
        roomRepository.deleteRoomsByHotelId(hotelId);
        hotelRepository.deleteById(hotelId);
    }

    public List<Room> getRoomsByHotelId(Long hotelId) {
        return roomRepository.findRoomsByHotelId(hotelId);
    }

    public void addHotel(String hotelName, String hotelAddress, Long cityId) {
        City city = cityRepository.findOne(cityId);
        Hotel newHotel = new Hotel(hotelName, hotelAddress, city);
        hotelRepository.save(newHotel);
    }
}
