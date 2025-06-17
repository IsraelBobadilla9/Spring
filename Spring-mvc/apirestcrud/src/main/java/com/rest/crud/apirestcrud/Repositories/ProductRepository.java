package com.rest.crud.apirestcrud.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.rest.crud.apirestcrud.Entities.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {
    
}
