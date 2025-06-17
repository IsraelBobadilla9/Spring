package com.springmicro.items.itemsmsvc.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmicro.items.itemsmsvc.client.ProductFeignClient;
import com.springmicro.items.itemsmsvc.models.Item;
import com.springmicro.items.itemsmsvc.models.ProductDTO;

import feign.FeignException;

@Service
public class ItemServiceFeign implements ItemService{

    @Autowired
    private ProductFeignClient clientP;

    @Override
    public List<Item> findAll() {
        return clientP.findAll().stream().map(product -> {
            Random random = new Random();
            return new Item(product,random.nextInt(10));
            
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<Item> findById(Long id) {
        
        try {
            ProductDTO product = null;
            product = clientP.detailsProduct(id);
            return Optional.of(new Item(product,new Random().nextInt(10)));
        } catch (FeignException e) {
            return Optional.empty();
        }
        
        
    }
    
}
