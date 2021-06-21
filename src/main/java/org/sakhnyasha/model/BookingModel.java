package org.sakhnyasha.model;

import lombok.*;
import org.sakhnyasha.entity.City;
import org.sakhnyasha.entity.Country;
import org.sakhnyasha.entity.Room;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BookingModel {
    private List<Country> countries;
    private Long selectedCountryId;
    private List<City> cities;
    private Long selectedCityId;
    private String checkIn;
    private String checkOut;
    private Integer capacity;
    private List<Room> availableRooms;
    private Long selectedRoom;

    public BookingModel(List<Country> countries) {
        this.countries = countries;
    }


}


