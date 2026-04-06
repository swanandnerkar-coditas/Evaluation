package com.task.OrderManagementSystem.dto;

import com.task.OrderManagementSystem.model.OrderItem;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class PlaceOrderDTO {

    // customer id
    @NonNull
    private Long id;

    // should not list of order, just orderlist which will add in list of order in service impl
//    private OrderItem orderItem;

    /*
        take product name & quantity : then at service save it
        create new DTO for OrderList
        as we want list of product
     */
    private List<OrderItemDTO> itemList;
}
