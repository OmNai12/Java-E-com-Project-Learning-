package com.example.SpringEcomProject.repository;

// Framework imports
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Project imports
import com.example.SpringEcomProject.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
