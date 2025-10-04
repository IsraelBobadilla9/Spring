package com.bobs.spring.core.spring_core_devs4js.setters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Madera {
    private String tipo;
    private Long longitud;

    public Madera() {
    }

    public Madera(String tipo, Long longitud) {
        this.tipo = tipo;
        this.longitud = longitud;
    }

    public String getTipo() {
        return tipo;
    }

    @Value("Pino")
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getLongitud() {
        return longitud;
    }

    @Value("90")
    public void setLongitud(Long longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Madera [tipo=" + tipo + ", longitud=" + longitud + "]";
    }

    
    
}
