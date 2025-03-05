package com.jatin.restaurantmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jatin.restaurantmanagement.Data.User;
import com.jatin.restaurantmanagement.Model.UserRegistrationDTO;
import com.jatin.restaurantmanagement.Service.User.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("/register")
    public User registerUser(@RequestBody UserRegistrationDTO userDTO) {
        return userService.registerUser(userDTO);
    }
}
