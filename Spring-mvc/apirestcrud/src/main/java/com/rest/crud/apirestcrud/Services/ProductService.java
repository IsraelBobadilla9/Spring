package com.rest.crud.apirestcrud.Services;

import java.util.List;
import java.util.Optional;

import com.rest.crud.apirestcrud.Entities.Product;

public interface ProductService {
    
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    Optional<Product> update(Long id,Product product);
    Optional<Product> delete(Long id);

}
