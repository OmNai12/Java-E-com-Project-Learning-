package com.example.SpringEcomProject.model;

// Java imports
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

// Freamework imports
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    private double price;

    private int quantity;

    private String brand;

    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date releaseDate;

    private boolean isAvailable;

    // The image handling

    private String imageName;
    
    private String imageType;

    @Lob
    private byte[] imageData;
}
