package com.bobs.spring.core.spring_core_devs4js.constructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cuerda {
    private String marca;
    private Long longitud;
    
    // public Cuerda() {// solo puede existir un constructor con autowired
    // }

    

    public Cuerda(@Value("Yamaha") String marca,@Value("20") Long longitud) {
        this.marca = marca;
        this.longitud = longitud;
    }



    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Long getLongitud() {
        return longitud;
    }

    public void setLongitud(Long longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Cuerda [marca=" + marca + ", longitud=" + longitud + "]";
    }
    
    

}
