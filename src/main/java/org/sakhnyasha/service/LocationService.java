package org.sakhnyasha.service;

import org.sakhnyasha.entity.City;
import org.sakhnyasha.entity.Country;
import org.sakhnyasha.entity.Hotel;
import org.sakhnyasha.repository.CityRepository;
import org.sakhnyasha.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LocationService {
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CityRepository cityRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public List<City> getAllCitiesForCountry(Long id) {
        return cityRepository.findCitiesByCountryId(id);
    }

    public void addCity(String name, Long countryId) {
        Country country = countryRepository.findOne(countryId);
        City newCity = new City(name, country);
        cityRepository.save(newCity);
    }
}
