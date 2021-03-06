package org.sakhnyasha.controller;

import org.sakhnyasha.entity.Booking;
import org.sakhnyasha.model.UserModel;
import org.sakhnyasha.service.BookingService;
import org.sakhnyasha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;


@Controller
//@RequestMapping(value = "", method = RequestMethod.POST)
public class UserManagementController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookingService bookingService;

    @GetMapping("/manager/userList")
    public ModelAndView userListView(){
        List<UserModel> users = userService.getAllUsers().stream()
                .map(user -> new UserModel(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getRole()))
                .collect(Collectors.toList());
        return new ModelAndView("userList", "users", users);
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

    @GetMapping("/manager/users/{userId}/orders")
    public ModelAndView userOrdersView(@PathVariable("userId") Long userId){
        List<Booking> usersBookings = bookingService.getUsersBookings(userId);
        return new ModelAndView("orders", "bookings", usersBookings);
    }


}
