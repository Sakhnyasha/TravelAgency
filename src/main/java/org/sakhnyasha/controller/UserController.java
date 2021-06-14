package org.sakhnyasha.controller;

import org.sakhnyasha.entity.Role;
import org.sakhnyasha.entity.User;
import org.sakhnyasha.model.RegistrationModel;
import org.sakhnyasha.model.UserModel;
import org.sakhnyasha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;


@Controller
//@RequestMapping(value = "", method = RequestMethod.POST)
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView register(){
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
    public ModelAndView userListView(){
        List<UserModel> users = userService.getAllUsers().stream()
                .map(user -> new UserModel(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getRole()))
                .collect(Collectors.toList());
        return new ModelAndView("userList", "users", users);
    }

    @GetMapping("/user/cabinet")
    public ModelAndView userCabinetView(){
        return new ModelAndView("userCabinet", "user", new RegistrationModel());
    }

    @PostMapping("/manager/userList/deleteUser")
    public String deleteUser(@ModelAttribute("userToDelete") Long userId)
    {
        userService.deleteUser(userId);
        return "redirect:/manager/userList";
    }

    @PostMapping("manager/userList/changeRoleUser")
    public String changeUserRole(@ModelAttribute("userToChangeRole") Long userId)
    {
        userService.changeRole(userId);
        return "redirect:/manager/userList";
    }


}
