package com.task.OrderManagementSystem.service;

import com.task.OrderManagementSystem.dto.ErrorResponse;
import com.task.OrderManagementSystem.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> getProduct(Long id);
}
