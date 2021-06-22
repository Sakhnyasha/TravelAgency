package org.sakhnyasha.controller;

import org.sakhnyasha.entity.Booking;
import org.sakhnyasha.security.UserPrincipal;
import org.sakhnyasha.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserCabinetController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/user/cabinet")
    public ModelAndView userCabinetView(){
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Booking> usersBookings = bookingService.getUsersBookings(principal.getId());
        return new ModelAndView("userCabinet", "bookings", usersBookings);
    }


}
