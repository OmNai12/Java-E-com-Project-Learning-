package com.example.SpringEcomProject.service;

// Java imports
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// Framework imports
import org.springframework.stereotype.Service;

// Project imports
import com.example.SpringEcomProject.model.Product;
import com.example.SpringEcomProject.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }
}