package com.example.SpringEcomProject.controllers;

// Java imports
import java.util.List;

// Framework imports
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// Project imports
import com.example.SpringEcomProject.service.ProductService;
import com.example.SpringEcomProject.model.Product;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    // The modified response entity is returned which returns the list of products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }
}
