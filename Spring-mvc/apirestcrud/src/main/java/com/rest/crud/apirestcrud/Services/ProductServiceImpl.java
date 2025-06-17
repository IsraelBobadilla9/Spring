package com.rest.crud.apirestcrud.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.crud.apirestcrud.Entities.Product;
import com.rest.crud.apirestcrud.Repositories.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;


    @Transactional( readOnly = true )
    @Override
    public List<Product> findAll(  ) {
        return (List<Product>)repository.findAll();
    }

    @Transactional( readOnly = true )
    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> productDb = repository.findById(id);
        if(productDb.isPresent()){
            Product pro = productDb.get(); 
            pro.setPrice(product.getPrice());
            pro.setNombre(product.getNombre());
            pro.setDescription(product.getDescription());
            return Optional.of(repository.save(pro));
        };
        return productDb;
    }


    @Transactional
    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> productDb = repository.findById(id);
        productDb.ifPresent(pro ->{
            repository.delete(pro);
        });
        return productDb;
    }

    
    
}
