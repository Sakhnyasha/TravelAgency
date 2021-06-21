package org.sakhnyasha.service;

import org.sakhnyasha.entity.Booking;
import org.sakhnyasha.entity.Room;
import org.sakhnyasha.repository.BookingRepository;
import org.sakhnyasha.repository.RoomRepository;
import org.sakhnyasha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class BookingService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Room> getAvailableRooms(Long cityId, Date checkIn, Date checkOut, Integer capacity){

        return roomRepository.findAvailableBookings(cityId, checkIn, checkOut, capacity);
    }

    public void saveBooking(Long userId, Long roomId, Date checkIn, Date checkOut){
        Booking newBooking = new Booking(userRepository.findOne(userId),
                roomRepository.findOne(roomId), checkIn, checkOut);
        bookingRepository.save(newBooking);
    }

    public List<Booking> getUsersBookings(Long userId){
        return bookingRepository.findBookingByUser(userId);
    }
}
