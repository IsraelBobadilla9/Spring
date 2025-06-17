package com.springcore.beans.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//  indica a java buscaar en toda la clase en busqueda de beans, durante el arranque comenzara por esta clase 
import org.springframework.context.annotation.Primary;

import com.springcore.beans.beans.Vehicle;
@Configuration
@ComponentScan(basePackages = "com.springcore.beans.beans")
public class ProjectConfig {

    @Bean
     Vehicle vehicle(){
        var veh = new Vehicle();
        veh.setName("Audi 8");
        return veh;
    }

    @Primary // previene ambiguedad y la exception
    @Bean(name = "ferrariVehicle")
    Vehicle vehicle2(){
       var veh = new Vehicle();
       veh.setName("    Ferrari 78k");
       return veh;
   }

    @Bean
    public String hello(){
        return "Hellow world";
    }
    @Bean
    public Integer number(){
        return 16;
    }
}
