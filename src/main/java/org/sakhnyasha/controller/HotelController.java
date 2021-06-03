package org.sakhnyasha.controller;

import org.sakhnyasha.model.Hotel;
import org.sakhnyasha.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotelList")
    public ModelAndView userListView(Model model){
        return new ModelAndView("hotelList", "hotel", new Hotel());
    }

    @GetMapping("/hotelAdding")
    public ModelAndView hotelAddView(Model model){
        return new ModelAndView("hotelAdding", "hotel", new Hotel());
    }



}






