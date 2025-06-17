package com.microservice.products.productsmsvc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.microservice.products.productsmsvc.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
    
}
