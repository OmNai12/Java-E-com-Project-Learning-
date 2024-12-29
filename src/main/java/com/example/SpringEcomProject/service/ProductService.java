package com.example.SpringEcomProject.service;

// Java imports
import java.util.List;

// Framework imports
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

// Project imports
import com.example.SpringEcomProject.model.Product;
import com.example.SpringEcomProject.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        try {
            return this.productRepository.findAll();
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'getProducts'");
        }
    }

    public Object getProductById(int id) {
        return this.productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) {
        try {
            // Setting the image name, type and data
            product.setImageName(imageFile.getOriginalFilename());
            product.setImageType(imageFile.getContentType());
            product.setImageData(imageFile.getBytes());
            return this.productRepository.save(product);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Something went wrong while adding the product" + e);
        }
    }


}