package org.sakhnyasha.controller;

import org.sakhnyasha.model.RegistrationModel;
import org.sakhnyasha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserCabinetController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/cabinet")
    public ModelAndView userCabinetView(){
        return new ModelAndView("userCabinet", "user", new RegistrationModel());
    }

}
