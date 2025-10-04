package com.bobs.spring.core.spring_core_devs4js.setters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mueble {
    
    private String marca;
    private Madera madera;

    public Mueble() {
    }

    public Mueble(String marca, Madera madera) {
        this.marca = marca;
        this.madera = madera;
    }

    public String getMarca() {
        return marca;
    }

    @Value("IKEA")
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Madera getMadera() {
        return madera;
    }

    @Autowired
    public void setMadera(Madera madera) {
        this.madera = madera;
    }

    @Override
    public String toString() {
        return "Mueble [marca=" + marca + ", madera=" + madera + "]";
    }

    
    



}
