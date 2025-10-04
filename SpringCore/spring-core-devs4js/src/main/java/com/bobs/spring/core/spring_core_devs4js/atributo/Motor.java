package com.bobs.spring.core.spring_core_devs4js.atributo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // Le indica a spring que el va a administrar
public class Motor {
    @Value("XL0")
    private String marca;
    @Value("0001")
    private Integer modelo;
    public Motor() {
    }
    public Motor(String marca, Integer modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public Integer getModelo() {
        return modelo;
    }
    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }
    @Override
    public String toString() {
        return "Motor [marca=" + marca + ", modelo=" + modelo + "]";
    }
    
}
