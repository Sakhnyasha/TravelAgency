package org.sakhnyasha.controller;

import org.sakhnyasha.entity.City;
import org.sakhnyasha.entity.Country;
import org.sakhnyasha.entity.Room;
import org.sakhnyasha.model.BookingModel;
import org.sakhnyasha.model.HotelModel;
import org.sakhnyasha.security.UserPrincipal;
import org.sakhnyasha.service.BookingService;
import org.sakhnyasha.service.HotelService;
import org.sakhnyasha.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@Controller
public class BookingController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/user/booking")
    public ModelAndView hotelBookView(){
        List<Country> countryList = locationService.getAllCountries();
        BookingModel booking = new BookingModel(countryList);
        return new ModelAndView("booking", "booking", booking);
    }

    @PostMapping("/user/booking")
    public ModelAndView getCitiesByCountryId(@ModelAttribute("booking") BookingModel bookingModel, Model model){
        List<Country> countryList = locationService.getAllCountries();
        List<City> cityList = locationService.getAllCitiesForCountry(bookingModel.getSelectedCountryId());
        bookingModel.setCountries(countryList);
        bookingModel.setCities(cityList);
        return new ModelAndView("booking", "booking", bookingModel);
    }

    @PostMapping("/user/booking/search")
    public ModelAndView hotelSearch(@ModelAttribute("booking") BookingModel bookingModel){
        List<Room> availableRooms = bookingService.getAvailableRooms(bookingModel.getSelectedCityId(),
                Date.valueOf(bookingModel.getCheckIn()),
                Date.valueOf(bookingModel.getCheckOut()), bookingModel.getCapacity());
        bookingModel.setAvailableRooms(availableRooms);

        return new ModelAndView("booking", "booking", bookingModel);
    }

    @PostMapping("/user/booking/submit")
    public String submitBooking(@ModelAttribute("booking") BookingModel bookingModel){
        UserPrincipal principal = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        bookingService.saveBooking(principal.getId(), bookingModel.getSelectedRoom(),
                Date.valueOf(bookingModel.getCheckIn()), Date.valueOf(bookingModel.getCheckOut()));
        return "redirect:/user/cabinet";
    }





}
