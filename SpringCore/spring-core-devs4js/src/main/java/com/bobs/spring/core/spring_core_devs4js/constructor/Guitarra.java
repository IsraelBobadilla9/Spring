package com.bobs.spring.core.spring_core_devs4js.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Guitarra {
    private String marca;
    private Integer precio;
    private Cuerda cuerda;

    public Guitarra() {
    }
    @Autowired
    public Guitarra(@Value("Parker") String marca,@Value("99999") Integer precio, Cuerda cuerda) {
        this.marca = marca;
        this.precio = precio;
        this.cuerda = cuerda;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public Integer getPrecio() {
        return precio;
    }
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    public Cuerda getCuerda() {
        return cuerda;
    }
    public void setCuerda(Cuerda cuerda) {
        this.cuerda = cuerda;
    }
    @Override
    public String toString() {
        return "Guitarra [marca=" + marca + ", precio=" + precio + ", cuerda=" + cuerda + "]";
    }

    

    

}
