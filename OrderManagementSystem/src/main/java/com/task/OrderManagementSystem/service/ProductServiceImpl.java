package com.task.OrderManagementSystem.service;

import com.task.OrderManagementSystem.exception.NotFoundException;
import com.task.OrderManagementSystem.model.Product;
import com.task.OrderManagementSystem.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getProduct(Long id) {
        if(id == null){
            return productRepo.findAll();
        }
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Course Course with Given Id not found"));
        return List.of(product);
    }
}
