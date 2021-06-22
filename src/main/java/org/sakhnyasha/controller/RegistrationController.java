package org.sakhnyasha.controller;


import org.sakhnyasha.entity.Role;
import org.sakhnyasha.entity.User;
import org.sakhnyasha.model.RegistrationModel;
import org.sakhnyasha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@Validated
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("register", "user", new RegistrationModel());
    }

    @PostMapping("/register")
    public String addUser(@Valid @ModelAttribute("user") RegistrationModel user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "register";
        }

        if(!user.getPassword().equals(user.getPasswordConfirmation())){
            bindingResult.rejectValue("passwordConfirmation", "user.passwordConfirmation",
                    "Password mismatch");
            return "register";
        }

        if(!user.getEmail().equals(userService.getUser(user.getEmail()).getEmail())){
            User newUser = new User(user.getEmail(), Role.USER, user.getFirstName(),
                    user.getLastName(), user.getPassword());
            userService.addUser(newUser);
            return "redirect:/login";
        }
        else {
            bindingResult.rejectValue("email", "user.email",
                    "An account already exists for this email");
            return "register";
        }

    }
}
