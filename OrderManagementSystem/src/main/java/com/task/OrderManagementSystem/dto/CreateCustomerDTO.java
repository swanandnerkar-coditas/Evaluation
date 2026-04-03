package com.task.OrderManagementSystem.dto;

import com.task.OrderManagementSystem.enums.Roles;
import lombok.Data;

@Data
public class CreateCustomerDTO {

    private String name;

    private Roles role;
}
