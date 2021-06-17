package org.sakhnyasha.controller;

import org.sakhnyasha.model.HotelModel;
import org.sakhnyasha.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookingController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/user/booking")
    public ModelAndView hotelBookView(Model model){
        return new ModelAndView("booking", "hotel", new HotelModel());
    }

}
