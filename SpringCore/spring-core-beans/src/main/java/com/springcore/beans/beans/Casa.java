package com.springcore.beans.beans;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Casa {
    private String tipo = " Departamento";

    @PostConstruct
    public void initialize(){
        this.tipo ="Casa dos pisos";
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Deley the object home :()");
    }



    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
