package com.bobs.spring.core.spring_core_devs4js.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Figure {
    // le indicamos que 1 sera el valor por default 
    @Value("${circle.radius:1}")
    private double radius;

    @Override
    public double calculateArea() {

        return Math.PI*Math.pow(radius, 2);
    }
    
}
