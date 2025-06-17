package com.springmicro.items.itemsmsvc.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.springmicro.items.itemsmsvc.models.Item;
import com.springmicro.items.itemsmsvc.models.ProductDTO;

@Primary
@Service
public class ItemServiceWebCLient implements ItemService{


    private final WebClient.Builder client;

    public ItemServiceWebCLient(Builder client) {
        this.client = client;
    }

    @Override
    public List<Item> findAll() {
        return this.client.build()
        .get()
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToFlux(ProductDTO.class)
        .map(product -> {
            Random random = new Random();
            return new Item(product,random.nextInt(10));
            
        })
        .collectList()
        .block();//con webflux no va porque hace un bloqueo y  no lo hace de manera asincrona
    }

    @Override
    public Optional<Item> findById(Long id) {
        Map<String,Long> params = new HashMap<>();
        params.put("id", id);
        try {
            return Optional.of(client.build().get().uri("http://productsmsvc/api/products/{id}",params)
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(ProductDTO.class)
        .map(product -> {
            Random random = new Random();
            return new Item(product,random.nextInt(10));
            
        })
        .block());
        } catch (WebClientResponseException e) {
            return Optional.empty();
        }
        

    }
    
}
