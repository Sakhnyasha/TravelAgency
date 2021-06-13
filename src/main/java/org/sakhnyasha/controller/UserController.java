package org.sakhnyasha.controller;

import org.sakhnyasha.entity.Role;
import org.sakhnyasha.entity.User;
import org.sakhnyasha.model.RegistrationModel;
import org.sakhnyasha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
//@RequestMapping(value = "", method = RequestMethod.POST)
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView register(Model model){
        return new ModelAndView("register", "user", new RegistrationModel());
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute("user") RegistrationModel user, BindingResult result, ModelMap model){

        User newUser = new User(user.getEmail(), Role.USER, user.getFirstName(),
                user.getLastName(), user.getPassword());
        userService.addUser(newUser);
        return "login";
    }

    @GetMapping("/manager/userList")
    public ModelAndView userListView(Model model){
        return new ModelAndView("userList", "user", new RegistrationModel());
    }

    @GetMapping("/user/cabinet")
    public ModelAndView userCabinetView(Model model){
        SecurityContextHolder.getContext().getAuthentication();
        return new ModelAndView("userCabinet", "user", new RegistrationModel());
    }


}
