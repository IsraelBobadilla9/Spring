package com.microservice.products.productsmsvc.services;

import java.util.List;
import java.util.Optional;

import com.microservice.products.productsmsvc.entities.Product;

public interface ProductService {
    
    List<Product> findAll();
    Optional<Product> findById(Long id); 

}
