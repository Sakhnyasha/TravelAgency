package org.sakhnyasha.controller;

import org.sakhnyasha.model.User;
import org.sakhnyasha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView register(Model model){
        System.out.println(model);
        return new ModelAndView("register", "user", new User());
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute("user") User user, BindingResult result, ModelMap model){
        System.out.println(model);
        return "test";
    }

    @GetMapping("/userList")
    public ModelAndView userListView(Model model){
        return new ModelAndView("userList", "user", new User());
    }


}
