package com.bobs.spring.core.spring_core_devs4js.qualifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pajarito")
public class Pajaro extends Animal implements Volador{
    public Pajaro(@Value("1") Integer edad,@Value("Azul") String nombre) {
        super(edad, nombre);
        //TODO Auto-generated constructor stub
    }
    private static final Logger log = LoggerFactory.getLogger(Pajaro.class);
    @Override
    public void volar() {
        log.info("Soy un pajao y estoy volando...");
    }
    
}
