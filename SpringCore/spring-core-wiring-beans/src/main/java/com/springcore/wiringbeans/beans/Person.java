package com.springcore.wiringbeans.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Person {
    private String name;
    
    @Autowired(required = false)
    private Vehicle vehicle;
    
    // @PostConstruct
    // public void init(){
    //     this.name ="israel";
    //     this.vehicle.setName("ferrari");
    // }

    public Person() {
        System.out.println("Person bean created by Spring");
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", vehicle=" + vehicle + "]";
    }
    
}
