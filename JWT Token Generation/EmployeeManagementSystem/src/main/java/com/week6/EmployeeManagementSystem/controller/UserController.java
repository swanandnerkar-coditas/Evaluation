package com.week6.EmployeeManagementSystem.controller;

import com.week6.EmployeeManagementSystem.model.User;
import com.week6.EmployeeManagementSystem.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){

        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        System.out.println("User : "+user);
        return userService.verify(user);
    }
}
