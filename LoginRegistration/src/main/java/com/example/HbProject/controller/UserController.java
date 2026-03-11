package com.example.HbProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.HbProject.entity.User;
import com.example.HbProject.service.UserService;
import com.example.HbProject.userAuth.LoginRequest;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // REGISTER API
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {

        return userService.register(user);
    }

    // LOGIN API
    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest loginRequest) {

        return userService.login(
                loginRequest.getUsernameOrEmail(),
                loginRequest.getPassword()
        );
    }
}