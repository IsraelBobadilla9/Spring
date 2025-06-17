package com.microservice.products.productsmsvc.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.products.productsmsvc.entities.Product;
import com.microservice.products.productsmsvc.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    // @Autowired
    // private ProductRepository productRepository;
    // es mejor inyectar desde el constructor 
    final private ProductRepository productRepository;
    final private Environment environment;
    public ProductServiceImpl( @Autowired ProductRepository productRepository, Environment environment){// usar @Autowired es redundante ya que spring lo hace 
        this.productRepository = productRepository;
        this.environment = environment;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return ((List<Product>)productRepository.findAll()).stream().map(product -> {
            product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            return product;
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id).map(product ->{
            product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            return product;
        });
    }
    
}
