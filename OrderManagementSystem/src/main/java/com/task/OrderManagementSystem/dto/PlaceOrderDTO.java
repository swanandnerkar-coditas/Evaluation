package com.task.OrderManagementSystem.dto;

import com.task.OrderManagementSystem.model.Order;
import com.task.OrderManagementSystem.model.OrderList;
import lombok.Data;

import java.util.List;

@Data
public class PlaceOrderDTO {

    // customer id
    private Long id;

    // should not list of order, just orderlist which will add in list of order in service impl
    private OrderList orderList;
}
