package com.springmicro.items.itemsmsvc.models;

public class Item {
    private ProductDTO product;
    private int quantity;

    public Item() {
    }
    
    public Item(ProductDTO product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }



    public ProductDTO getProduct() {
        return product;
    }
    public void setProduct(ProductDTO product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getTotal(){
        return product.getPrice()*quantity;
    }

    @Override
    public String toString() {
        return "Items [product=" + product + ", quantity=" + quantity + "]";
    }

    
}
