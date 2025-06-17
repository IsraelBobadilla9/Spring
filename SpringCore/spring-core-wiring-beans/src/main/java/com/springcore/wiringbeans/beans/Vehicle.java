package com.springcore.wiringbeans.beans;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    private String name;

    public Vehicle() {
        System.out.println("Vehicle bean created by spring");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle [name=" + name + "]";
    }

    
    

}
