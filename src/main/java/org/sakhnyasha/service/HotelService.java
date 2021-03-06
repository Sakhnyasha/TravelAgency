package org.sakhnyasha.service;

import org.sakhnyasha.entity.City;
import org.sakhnyasha.entity.Hotel;
import org.sakhnyasha.entity.Room;
import org.sakhnyasha.repository.BookingRepository;
import org.sakhnyasha.repository.CityRepository;
import org.sakhnyasha.repository.HotelRepository;
import org.sakhnyasha.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private BookingRepository bookingRepository;


    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public void deleteHotel(Long hotelId) {
        roomRepository.findRoomsByHotelId(hotelId).forEach(room->
                bookingRepository.deleteBookingsForRoom(room.getId()));
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

    public void addRoom(String name, Double price, Integer capacity, Long hotelId){
        Hotel hotel = hotelRepository.findOne(hotelId);
        Room newRoom = new Room(name, price, capacity, hotel);
        roomRepository.save(newRoom);
    }

}
