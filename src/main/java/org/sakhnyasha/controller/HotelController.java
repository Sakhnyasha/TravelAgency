package org.sakhnyasha.controller;

import org.sakhnyasha.model.HotelModel;
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

    @GetMapping("/manager/hotelList")
    public ModelAndView userListView(Model model){
        return new ModelAndView("hotelList", "hotel", new HotelModel());
    }

    @GetMapping("/manager/hotelAdding")
    public ModelAndView hotelAddView(Model model){
        return new ModelAndView("hotelAdding", "hotel", new HotelModel());
    }

    @GetMapping("/user/booking")
    public ModelAndView hotelBookView(Model model){
        return new ModelAndView("booking", "hotel", new HotelModel());
    }




}






