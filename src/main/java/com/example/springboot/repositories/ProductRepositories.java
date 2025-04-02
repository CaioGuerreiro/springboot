package com.example.springboot.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.models.ProductModel;


@Repository
public interface ProductRepositories extends JpaRepository<ProductModel, UUID> {
    // This interface will automatically provide CRUD operations for ProductModel
    // No need to implement any methods here

}
