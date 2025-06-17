package com.rest.crud.apirestcrud.Entities;

import com.rest.crud.apirestcrud.Validation.IsRequired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table( name = "products" )
public class Product {
    
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Long id;

    @NotEmpty(message = "{NotEmpty.product.name}")
    @Size(min = 3, max = 150, message = "{Size.product.name}")
    private String nombre;
    
    @Min(value = 200, message="{Min.product.price}")
    @NotNull(message = "NotNull.product.price")
    private int price;
    @IsRequired
    @NotEmpty(message = "NotBlanck.product.description")
    private String description;

    

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", nombre=" + nombre + ", price=" + price + ", description=" + description + "]";
    }

    

}
