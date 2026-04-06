package com.task.OrderManagementSystem.service;

import com.task.OrderManagementSystem.dto.ErrorResponse;

import java.util.List;

public interface UserService {
    String validateUser(Long userId, Integer password);
}
