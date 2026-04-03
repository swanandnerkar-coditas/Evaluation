package com.task.OrderManagementSystem.controller;

import com.task.OrderManagementSystem.dto.ApplicationResponse;
import com.task.OrderManagementSystem.dto.CreateCustomerDTO;
import com.task.OrderManagementSystem.dto.PlaceOrderDTO;
import com.task.OrderManagementSystem.model.Customer;
import com.task.OrderManagementSystem.model.Product;
import com.task.OrderManagementSystem.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

//    @PostMapping
//    public ResponseEntity<ApplicationResponse<Customer>> createCustomer(@RequestBody Customer customer){
//        ApplicationResponse<Customer> response = new ApplicationResponse<>(customerService.createCustomer(customer));
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }

    @PostMapping
    public ResponseEntity<ApplicationResponse<Customer>> createCustomer(@RequestBody CreateCustomerDTO createCustomerDTO){
        ApplicationResponse<Customer> response = new ApplicationResponse<>(customerService.createCustomer(createCustomerDTO));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<ApplicationResponse<List<Customer>>> getCustomer(
            @RequestParam(required = false) Long id){
        ApplicationResponse<List<Customer>> response = new ApplicationResponse<>(customerService.getCustomer(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/order_place")
    public ResponseEntity<ApplicationResponse<Customer>> enrollStudent(@RequestBody PlaceOrderDTO placeOrderDTO){
        ApplicationResponse<Customer> response = new ApplicationResponse<>(customerService.placeOrderList(placeOrderDTO));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
