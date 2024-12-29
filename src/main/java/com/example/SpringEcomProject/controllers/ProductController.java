package com.example.SpringEcomProject.controllers;

// Framework imports
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ProductController {
    
    @GetMapping("/products")
    public String getProducts() {
        return "products";
    }
}
