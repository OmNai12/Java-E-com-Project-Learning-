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

    // The method returns the list of products
    public List<Product> getProducts() {
        try {
            return this.productRepository.findAll();
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'getProducts'");
        }
    }

    // The method returns the product by id
    public Object getProductById(int id) {
        return this.productRepository.findById(id).orElse(null);
    }

    // The method adds the product
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

    // The method updates the product
    public Product updateProduct(int id, Product product, MultipartFile imageFile) {
        try {
            Product existingProduct = this.productRepository.findById(id).orElse(null);
            if (existingProduct != null) {
                existingProduct.setImageName(imageFile.getOriginalFilename());
                existingProduct.setImageType(imageFile.getContentType());
                existingProduct.setImageData(imageFile.getBytes());
                return this.productRepository.save(existingProduct);
            } else {
                throw new UnsupportedOperationException("Product not found");
            }
        } catch (Exception e) {
            throw new UnsupportedOperationException("Something went wrong while updating the product" + e);
        }
    }

    // The method deletes the product
    public void deleteProduct(int id) {
        try {
            this.productRepository.deleteById(id);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Something went wrong while deleting the product" + e);
        }
    }


}