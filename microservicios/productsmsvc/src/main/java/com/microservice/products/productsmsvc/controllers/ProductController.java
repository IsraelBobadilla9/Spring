package com.microservice.products.productsmsvc.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.microservice.products.productsmsvc.entities.Product;
import com.microservice.products.productsmsvc.services.ProductService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    final private ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }

    @GetMapping
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> detailsProduct(@PathVariable Long id) {
        Optional<Product> optProduct = service.findById(id);
        if(optProduct.isPresent()){
            return ResponseEntity.ok().body(optProduct.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    

}
