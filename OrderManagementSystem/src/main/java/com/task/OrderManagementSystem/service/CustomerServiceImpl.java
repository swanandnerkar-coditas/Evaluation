package com.task.OrderManagementSystem.service;

import com.task.OrderManagementSystem.dto.CreateCustomerDTO;
import com.task.OrderManagementSystem.dto.PlaceOrderDTO;
import com.task.OrderManagementSystem.exception.NotFoundException;
import com.task.OrderManagementSystem.model.Customer;
import com.task.OrderManagementSystem.model.Order;
import com.task.OrderManagementSystem.model.OrderList;
import com.task.OrderManagementSystem.repo.CustomerRepo;
import com.task.OrderManagementSystem.repo.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepo customerRepo;
    private final OrderRepo orderRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo, OrderRepo orderRepo) {
        this.customerRepo = customerRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer createCustomer(CreateCustomerDTO createCustomerDTO) {
        if(createCustomerDTO == null) throw new NotFoundException("Customer fields are empty");
        Customer customer = new Customer();
        customer.setName(createCustomerDTO.getName());
        customer.setRole(createCustomerDTO.getRole());
        return customerRepo.save(customer);
    }

    @Override
    public List<Customer> getCustomer(Long id) {
        if(id == null){
            return customerRepo.findAll();
        }
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Course Course with Given Id not found"));
        return List.of(customer);
    }

    @Override
    public Customer placeOrderList(PlaceOrderDTO placeOrderDTO) {
        Long id = placeOrderDTO.getId();
        Customer customer = customerRepo.findById(id)
                .orElseThrow(()-> new NotFoundException("Course Course with Given Id not found"));

        OrderList orderList = placeOrderDTO.getOrderList();
        if(orderList == null ) throw new NotFoundException("Order list is empty");

        // adding in list
        Order order = new Order();
        order.setCustomer(customer);
        order.getOrderListList().add(orderList);
        orderRepo.save(order);

        // saving order into OrderList
        orderList.setOrder(order);
        customer.getOrderList().add(order);

//        customer.setOrderList(placeOrderDTO.getOrderList());
        return customerRepo.save(customer);
    }

}
