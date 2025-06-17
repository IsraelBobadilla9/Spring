package com.springmicro.items.itemsmsvc.models;

import java.time.LocalDate;

public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private LocalDate createAt;
    private int port;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public LocalDate getCreateAt() {
        return createAt;
    }
    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", createAt=" + createAt + "]";
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }

    
    
}
