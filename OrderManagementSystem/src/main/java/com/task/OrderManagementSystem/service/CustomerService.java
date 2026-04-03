package com.task.OrderManagementSystem.service;

import com.task.OrderManagementSystem.dto.CreateCustomerDTO;
import com.task.OrderManagementSystem.dto.ErrorResponse;
import com.task.OrderManagementSystem.dto.PlaceOrderDTO;
import com.task.OrderManagementSystem.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);

    Customer createCustomer(CreateCustomerDTO createCustomerDTO);

    List<Customer> getCustomer(Long id);

    Customer placeOrderList(PlaceOrderDTO placeOrderDTO);
}
