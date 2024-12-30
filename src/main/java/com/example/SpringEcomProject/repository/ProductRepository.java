package com.example.SpringEcomProject.repository;

// Java imports
import java.util.List;

// Framework imports
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// Project imports
import com.example.SpringEcomProject.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE "
            + "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
            + "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
            + "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
            + "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> searchProducts(String keyword);
}
