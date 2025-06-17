package com.springcore.wiringbeans.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springcore.wiringbeans.beans.Person;
import com.springcore.wiringbeans.beans.Vehicle;

@Configuration
@ComponentScan(basePackages = "com.springcore.wiringbeans.beans")
public class ProjectConfig {
    
    // @Bean
    // public Vehicle vehicle(){
    //     Vehicle vehicle = new Vehicle();
    //     vehicle.setName("Toyota");
    //     return vehicle;
    // }

    // @Bean
    // public Person person(){
    //     Person person = new Person();
    //     person.setName("israel");
    //     person.setVehicle(vehicle());// solo crea un bean
    //     return person;
    // }

    // Podemos pasarlo como parametro:
    // @Bean
    // public Person person(Vehicle vehicle){
    //     Person person = new Person();
    //     person.setName("israel");
    //     person.setVehicle(vehicle);// inyecta el bean
    //     return person;
    // }


}
