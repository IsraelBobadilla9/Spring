package com.springcore.wiringbeans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcore.wiringbeans.beans.Person;
import com.springcore.wiringbeans.beans.Vehicle;
import com.springcore.wiringbeans.config.ProjectConfig;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person person = context.getBean(Person.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println("Person name from spring context is  "+person.getName());
        System.out.println("Vehicle name from spring context is "+vehicle.getName());
        System.out.println("vehicle that person own is"+person.getVehicle());

    }
}