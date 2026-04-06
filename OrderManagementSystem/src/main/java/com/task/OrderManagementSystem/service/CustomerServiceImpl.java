package com.task.OrderManagementSystem.service;

import com.task.OrderManagementSystem.dto.CreateCustomerDTO;
import com.task.OrderManagementSystem.dto.OrderItemDTO;
import com.task.OrderManagementSystem.dto.PlaceOrderDTO;
import com.task.OrderManagementSystem.enums.Status;
import com.task.OrderManagementSystem.exception.NotFoundException;
import com.task.OrderManagementSystem.model.Customer;
import com.task.OrderManagementSystem.model.Order;
import com.task.OrderManagementSystem.model.OrderItem;
import com.task.OrderManagementSystem.model.Product;
import com.task.OrderManagementSystem.repo.CustomerRepo;
import com.task.OrderManagementSystem.repo.OrderRepo;
import com.task.OrderManagementSystem.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepo customerRepo;
    private final OrderRepo orderRepo;

    private final ProductRepo productRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo, OrderRepo orderRepo, ProductRepo productRepo) {
        this.customerRepo = customerRepo;
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
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

    /*
        get list of OrderItemDTO : productId & quantity
        get it into OrderItem
        use loop to set OrderItem from OrderItemDTO then only save Order which should save OrderItem as well
        then check through AOP / validation whether quantity is present or not : Before
        if yes then reduce it from Product as well

        it's messy : will separate later

        assuming while saving Order : List of OrderItem will save its Order (id)
        instead of addAll go with normal add

        status is remaining
        check reducing quantity as well : works
     */
    @Override
    public Customer placeOrderList(PlaceOrderDTO placeOrderDTO) {
        Long id = placeOrderDTO.getId();
        Customer customer = customerRepo.findById(id)
                .orElseThrow(()-> new NotFoundException("Course with Given Id not found"));

        List<OrderItemDTO> orderItemDTOList = placeOrderDTO.getItemList();
        if(orderItemDTOList == null ) throw new NotFoundException("Order list is empty");

        List<OrderItem> inputOrderItemList = new ArrayList<>(); // create list add data & put it into Order ( while saving it to DB )

        Order order = new Order();
        order.setCustomer(customer);

        for(OrderItemDTO orderItemDTO : orderItemDTOList){
            OrderItem orderItem = new OrderItem();
            Product product = productRepo.findById(orderItemDTO.getProductId())
                    .orElseThrow(()-> new NotFoundException("Product Not found for provided Id"));
            orderItem.setProduct(product);
            orderItem.setQuantity(orderItemDTO.getQuantity());
            orderItem.setOrder(order);
            inputOrderItemList.add(orderItem);

            // reducing product available quantity
            Integer remainingQuantity = product.getQuantity() - orderItem.getQuantity();
            product.setQuantity(remainingQuantity);
            productRepo.save(product);
        }

        order.getOrderItemList().addAll(inputOrderItemList);
        order.setStatus(Status.PLACED);
        customer.getOrderList().add(order);
        orderRepo.save(order);  // breaking here, no need as Customer cascade persist will do

        // saving order into OrderItem
//        orderItem.setOrder(order);

//        customer.setOrderList(placeOrderDTO.getOrderList());
        return customerRepo.save(customer);
    }

    /*
        for transaction
     */
    @Override
    public String payment(Long customerId, Long orderId) {
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(()-> new NotFoundException("Course with Given Id not found"));

        orderRepo.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order not found for this Order id"));

        return "Payment Done Successfully";
    }

}
