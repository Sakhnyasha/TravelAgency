package org.sakhnyasha.controller;

import org.sakhnyasha.entity.City;
import org.sakhnyasha.entity.Country;
import org.sakhnyasha.entity.Room;
import org.sakhnyasha.model.BookingModel;
import org.sakhnyasha.security.UserPrincipal;
import org.sakhnyasha.service.BookingService;
import org.sakhnyasha.service.HotelService;
import org.sakhnyasha.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import java.sql.Date;
import java.util.List;

@Controller
@Validated
public class BookingController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/user/booking")
    public ModelAndView hotelBookView(Model model){
        List<Country> countryList = locationService.getAllCountries();
        model.addAttribute("countries", countryList);
        BookingModel booking = new BookingModel();
        return new ModelAndView("booking", "booking", booking);
    }

    @PostMapping("/user/booking")
    public ModelAndView getCitiesByCountryId(@Validated(BookingModel.ValidationStepOne.class)
                                                 @ModelAttribute("booking") BookingModel bookingModel,
                                             Model model){
        List<Country> countryList = locationService.getAllCountries();
        List<City> cityList = locationService.getAllCitiesForCountry(bookingModel.getSelectedCountryId());
        model.addAttribute("countries", countryList);
        model.addAttribute("cities", cityList);
        model.addAttribute("currentCheckIn", bookingModel.getCheckIn());
        model.addAttribute("currentCheckOut", bookingModel.getCheckOut());
        model.addAttribute("currentCapacity", bookingModel.getCapacity());
        model.addAttribute("selectedCountryId", bookingModel.getSelectedCountryId());
        return new ModelAndView("booking", "booking", bookingModel);
    }

    @PostMapping("/user/booking/search")
    public ModelAndView hotelSearch(@Validated(BookingModel.ValidationStepTwo.class)
                                        @ModelAttribute("booking") BookingModel bookingModel,
                                    BindingResult bindingResult, Model model){
        List<Country> countryList = locationService.getAllCountries();
        City city = locationService.getCity(bookingModel.getSelectedCityId());
        List<City> cityList = locationService.getAllCitiesForCountry(city.getCountry().getId());
        model.addAttribute("countries", countryList);
        model.addAttribute("cities", cityList);
        model.addAttribute("selectedCountryId", city.getCountry().getId());
        model.addAttribute("selectedCity", city.getId());
        model.addAttribute("selectedRoom", bookingModel.getSelectedRoom());
        model.addAttribute("currentCheckIn", bookingModel.getCheckIn());
        model.addAttribute("currentCheckOut", bookingModel.getCheckOut());
        model.addAttribute("currentCapacity", bookingModel.getCapacity());

        if(Date.valueOf(bookingModel.getCheckIn()).after(Date.valueOf(bookingModel.getCheckOut()))){
            bindingResult.rejectValue("checkOut", "booking.checkOut",
                    "Check Out must be after Check In");
//            return new ModelAndView("booking", "booking", bookingModel);
        }

        Date dateCurrent = new Date(System.currentTimeMillis());
        if(dateCurrent.after(Date.valueOf(bookingModel.getCheckIn()))){
            bindingResult.rejectValue("checkIn", "booking.checkIn",
                    "Check In must be in future");

        }

        if(dateCurrent.after(Date.valueOf(bookingModel.getCheckOut()))){
            bindingResult.rejectValue("checkOut", "booking.checkOut",
                    "Check Out must be in future");
        }

        if(bindingResult.hasErrors()){
            return new ModelAndView("booking", "booking", bookingModel);
        }


        List<Room> availableRooms = bookingService.getAvailableRooms(bookingModel.getSelectedCityId(),
                Date.valueOf(bookingModel.getCheckIn()),
                Date.valueOf(bookingModel.getCheckOut()), bookingModel.getCapacity());
        bookingModel.setAvailableRooms(availableRooms);

        return new ModelAndView("booking", "booking", bookingModel);
    }

    @PostMapping("/user/booking/submit")
    public String submitBooking(@Validated(BookingModel.ValidationStepThree.class)
                                    @ModelAttribute("booking") BookingModel bookingModel,
                                BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("selectedRoom", bookingModel.getSelectedRoom());
            model.addAttribute("currentCheckIn", bookingModel.getCheckIn());
            model.addAttribute("currentCheckOut", bookingModel.getCheckOut());
            model.addAttribute("currentCapacity", bookingModel.getCapacity());
            return "booking";
        }

        UserPrincipal principal = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        bookingService.saveBooking(principal.getId(), bookingModel.getSelectedRoom(),
                Date.valueOf(bookingModel.getCheckIn()), Date.valueOf(bookingModel.getCheckOut()));
        return "redirect:/user/cabinet";
    }





}
