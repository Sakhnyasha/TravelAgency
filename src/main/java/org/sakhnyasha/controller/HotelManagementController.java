package org.sakhnyasha.controller;


import org.sakhnyasha.entity.City;
import org.sakhnyasha.entity.Country;
import org.sakhnyasha.entity.Room;
import org.sakhnyasha.model.CityModel;
import org.sakhnyasha.model.HotelModel;
import org.sakhnyasha.model.NewHotelModel;
import org.sakhnyasha.model.RoomModel;
import org.sakhnyasha.service.HotelService;
import org.sakhnyasha.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Validated
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
    public String saveHotel(@Valid @ModelAttribute("newHotel")NewHotelModel newHotel,
                            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            City city = locationService.getCity(newHotel.getCityId());
            model.addAttribute("selectedCountry", city.getCountry().getId());
            model.addAttribute("hotelName", newHotel.getHotelName());
            model.addAttribute("address", newHotel.getHotelAddress());
            List<Country> countryList = locationService.getAllCountries();
            List<City> allCitiesForCountry =
                    locationService.getAllCitiesForCountry(city.getCountry().getId());
            model.addAttribute("countries", countryList);
            model.addAttribute("cities", allCitiesForCountry);
            model.addAttribute("selectedCity", newHotel.getCityId());
            return "hotelAdding";
        }

        hotelService.addHotel(newHotel.getHotelName(), newHotel.getHotelAddress(), newHotel.getCityId());

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
        return new ModelAndView("cityAdding", "city", new CityModel());
    }

    @PostMapping("/manager/cities/add")
    public String addCity(@Valid @ModelAttribute("city") CityModel city,
                          BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("countries", locationService.getAllCountries());
            model.addAttribute("currentCity", city.getName());
            return "cityAdding";
        }
        locationService.addCity(city.getName(), city.getCountryId());
        return "redirect:/manager/hotels";
    }

    @GetMapping("/hotels/{hotelId}/rooms/add")
    public ModelAndView addRoomView(@PathVariable("hotelId") Long hotelId) {
        return new ModelAndView("roomAdding", "hotelId", hotelId);
    }

    @PostMapping("/hotels/{hotelId}/rooms/add")
    public String addRoom(@Valid @ModelAttribute("room")RoomModel room, BindingResult bindingResult,
                          @PathVariable("hotelId") Long hotelId, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("name", room.getName());
            model.addAttribute("price", room.getPrice());
            model.addAttribute("capacity", room.getCapacity());
            return "roomAdding";
        }
        hotelService.addRoom(room.getName(), room.getPrice(), room.getCapacity(), hotelId);

        return "redirect:/hotels/" + hotelId + "/rooms";
    }


}






