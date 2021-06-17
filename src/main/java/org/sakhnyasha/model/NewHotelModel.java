package org.sakhnyasha.model;

import lombok.Data;
import org.sakhnyasha.entity.City;
import org.sakhnyasha.entity.Country;

import java.util.List;
@Data
public class NewHotelModel {
    private List<Country> countryList;
    private List<City> cityList;
    private HotelModel newHotel;

}
