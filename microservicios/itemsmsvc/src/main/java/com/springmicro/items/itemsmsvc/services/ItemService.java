package com.springmicro.items.itemsmsvc.services;

import java.util.List;
import java.util.Optional;

import com.springmicro.items.itemsmsvc.models.Item;

public interface ItemService {
    List<Item> findAll();
    Optional<Item> findById(Long id);
}
