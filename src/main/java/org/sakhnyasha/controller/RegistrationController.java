package org.sakhnyasha.controller;

import org.sakhnyasha.entity.Role;
import org.sakhnyasha.entity.User;
import org.sakhnyasha.model.RegistrationModel;
import org.sakhnyasha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("register", "user", new RegistrationModel());
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute("user") RegistrationModel user){

        User newUser = new User(user.getEmail(), Role.USER, user.getFirstName(),
                user.getLastName(), user.getPassword());
        userService.addUser(newUser);
        return "redirect:/login";
    }
}
