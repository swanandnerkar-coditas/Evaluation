package com.week6.EmployeeManagementSystem.service;


import com.week6.EmployeeManagementSystem.model.User;

public interface UserService {

    User register(User user);

    String verify(User user);
}
