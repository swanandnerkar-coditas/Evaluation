package com.task.OrderManagementSystem.controller;

import com.task.OrderManagementSystem.dto.ApplicationResponse;
import com.task.OrderManagementSystem.dto.CreateCustomerDTO;
import com.task.OrderManagementSystem.model.Customer;
import com.task.OrderManagementSystem.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login/{userId}/{password}")
    public ResponseEntity<ApplicationResponse<String>> validateUser(@PathVariable Long userId, @PathVariable Integer password){
        ApplicationResponse<String> response = new ApplicationResponse<>(userService.validateUser(userId, password));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
