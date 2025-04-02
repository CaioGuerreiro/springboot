package com.example.springboot.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.springboot.dtos.ProductRecordDtos;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepositories;

import jakarta.validation.Valid;

@RestController
public class ProductController {
    
    @Autowired
    ProductRepositories productRepositories;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDtos productRecordDtos){

        var ProductModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDtos, ProductModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(productRepositories.save(ProductModel));
        
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productRepositories.findAll());
    }
}


