package org.sakhnyasha.controller;

import org.sakhnyasha.entity.City;
import org.sakhnyasha.entity.Country;
import org.sakhnyasha.entity.Room;
import org.sakhnyasha.model.HotelModel;
import org.sakhnyasha.service.HotelService;
import org.sakhnyasha.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HotelManagementController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private LocationService locationService;

    @GetMapping("/manager/hotels")
    public ModelAndView hotelListView() {
        List<HotelModel> hotelModels = hotelService.getAllHotels().stream().map(hotel ->
                new HotelModel(hotel.getId(), hotel.getName(),
                        hotel.getAddress(), hotel.getCity().getCountry().getName(),
                        hotel.getCity().getName())).collect(Collectors.toList());
        return new ModelAndView("hotelList", "hotels", hotelModels);
    }

    @GetMapping("/manager/hotels/add")
    public ModelAndView hotelAddView(Model model) {
        List<Country> countryList = locationService.getAllCountries();
        model.addAttribute("countries", countryList);
        return new ModelAndView("hotelAdding");
    }

    @PostMapping("/manager/hotels/add")
    public String getCitiesForCountry(@ModelAttribute("selectedCountry") Long selectedCountry, Model model) {
        List<City> allCitiesForCountry = locationService.getAllCitiesForCountry(selectedCountry);
        List<Country> countryList = locationService.getAllCountries();
        model.addAttribute("countries", countryList);
        model.addAttribute("cities", allCitiesForCountry);
        return "hotelAdding";
    }


    @PostMapping("/manager/hotels/add/success")
    public String saveHotel(@ModelAttribute("cityId") Long cityId,
                            @ModelAttribute("address") String hotelAddress,
                            @ModelAttribute("hotelName") String hotelName) {
        hotelService.addHotel(hotelName, hotelAddress, cityId);

        return "redirect:/manager/hotels";
    }

    @PostMapping("/manager/hotels/delete")
    public String deleteUser(@ModelAttribute("hotelToDelete") Long hotelId) {
        hotelService.deleteHotel(hotelId);
        return "redirect:/manager/hotels";
    }

    @GetMapping("/hotels/{hotelId}/rooms")
    public ModelAndView roomEditView(@PathVariable("hotelId") Long hotelId) {
        List<Room> roomsByHotelId = hotelService.getRoomsByHotelId(hotelId);
        return new ModelAndView("roomList", "rooms", roomsByHotelId);
    }


    @GetMapping("/manager/cities")
    public ModelAndView addCityView(Model model) {
        List<Country> countryList = locationService.getAllCountries();
        model.addAttribute("countries", countryList);
        return new ModelAndView("cityAdding");
    }

    @PostMapping("/manager/cities/add")
    public String addCity(@ModelAttribute("city") String cityName, @ModelAttribute("selectedCountry") Long countryId) {
        locationService.addCity(cityName, countryId);
        return "redirect:/manager/hotels";
    }

    @GetMapping("/hotels/{hotelId}/rooms/add")
    public ModelAndView addRoomView(@PathVariable("hotelId") Long hotelId) {
        return new ModelAndView("roomAdding", "hotelId", hotelId);
    }

    @PostMapping("/hotels/{hotelId}/rooms/add")
    public String addRoom(@ModelAttribute("name") String roomName, @ModelAttribute("price") Double price,
                                    @ModelAttribute("capacity") Integer capacity,
                              @PathVariable("hotelId") Long hotelId) {
        locationService.addRoom(roomName, price, capacity, hotelId);

        return "redirect:/hotels/" + hotelId + "/rooms";
    }



}






