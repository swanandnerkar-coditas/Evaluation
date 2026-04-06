package com.task.OrderManagementSystem.service;

import com.task.OrderManagementSystem.exception.NotFoundException;
import com.task.OrderManagementSystem.exception.ValidationException;
import com.task.OrderManagementSystem.model.Customer;
import com.task.OrderManagementSystem.model.User;
import com.task.OrderManagementSystem.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public String validateUser(Long userId, Integer password) {
        User user = userRepo.findById(userId)
                .orElseThrow(()-> new NotFoundException("User not found for provided user Id"));

        Integer realPassword = user.getPassword();
        if(realPassword != password)
            throw new ValidationException("Password not matched");

        return "User Authenticated Successfully";
    }
}
