package com.example.HbProject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HbProject.entity.User;
import com.example.HbProject.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(User user) {

        if(userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "Username already exists";
        }

        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "Email already exists";
        }

        userRepository.save(user);

        return "User Registered Successfully";
    }

    public String login(String usernameOrEmail, String password) {

        Optional<User> user =
                userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);

        if(user.isEmpty()) {
            return "Invalid username/email";
        }

        if(password.equals( user.get().getPassword())) {
            return "Login Successful";
        }

        return "Invalid Password";
    }
}
