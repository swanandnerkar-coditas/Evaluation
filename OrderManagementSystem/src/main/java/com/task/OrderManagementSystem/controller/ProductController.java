package com.task.OrderManagementSystem.controller;

import com.task.OrderManagementSystem.dto.ApplicationResponse;
import com.task.OrderManagementSystem.model.Product;
import com.task.OrderManagementSystem.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ApplicationResponse<Product>> createCustomer(@RequestBody Product product){
        ApplicationResponse<Product> response = new ApplicationResponse<>(productService.createProduct(product));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<ApplicationResponse<List<Product>>> getProduct(
            @RequestParam(required = false) Long id){
        ApplicationResponse<List<Product>> response = new ApplicationResponse<>(productService.getProduct(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
