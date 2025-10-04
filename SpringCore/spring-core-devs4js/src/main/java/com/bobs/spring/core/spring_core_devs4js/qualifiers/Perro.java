package com.bobs.spring.core.spring_core_devs4js.qualifiers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Perro extends Animal{

    public Perro(@Value("9898") Integer edad,@Value("chihuhua") String nombre) {
        super(edad, nombre);
        //TODO Auto-generated constructor stub
    }

    
    
}
