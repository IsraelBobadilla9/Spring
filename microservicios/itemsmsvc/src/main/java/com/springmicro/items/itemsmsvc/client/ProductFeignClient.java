package com.springmicro.items.itemsmsvc.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springmicro.items.itemsmsvc.models.Item;
import com.springmicro.items.itemsmsvc.models.ProductDTO;

@FeignClient( name = "productsmsvc")
public interface ProductFeignClient{
    
    // metodos mapeados a rutas

    @GetMapping("/api/products")
    List<ProductDTO> findAll();

    @GetMapping("/{id}")
    public ProductDTO detailsProduct(@PathVariable Long id);

}
