package com.springmicro.items.itemsmsvc.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.springmicro.items.itemsmsvc.models.Item;
import com.springmicro.items.itemsmsvc.services.ItemService;

import feign.Response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ItemController {
    
    
    private final ItemService service;

    public ItemController(@Qualifier("itemServiceWebCLient") ItemService service){
        this.service = service;
    }

    @GetMapping
    public List<Item> list() {
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Item> itemOptional = service.findById(id);
        if(itemOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(itemOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
    


}
