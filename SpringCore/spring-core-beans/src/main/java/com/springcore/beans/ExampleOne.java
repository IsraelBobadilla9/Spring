package com.springcore.beans;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcore.beans.beans.Casa;
import com.springcore.beans.beans.Vehicle;
import com.springcore.beans.config.ProjectConfig;

public class ExampleOne {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Honda city");
        System.out.println("Fuera del contexto de spring"+vehicle.getName());
        //Aqui se inicializa el spring container 
        AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle vhe = context.getBean("vehicle",Vehicle.class);
        System.out.println("Desde el contexto"+vhe.getName());

        String hola = (String)context.getBean("hello");
        System.out.println("Desde el contexto hello"+hola);
        Integer num = context.getBean(Integer.class);
        System.out.println("Dentro del context integer: "+num);

        var vhe2 = context.getBean("ferrariVehicle",Vehicle.class);
        System.out.println("Desde el contexto "+vhe2.getName());

        var vhe3 = context.getBean(Vehicle.class);
        System.out.println("Desde el contexto 3 PRIMARY "+vhe3.getName());

        Casa miCasa = context.getBean(Casa.class);
        System.out.println("Desde el contexto 4 Casa "+miCasa.getTipo());


        // implementacion functional interface
        Vehicle volkswagen = new Vehicle();
        volkswagen.setName("Volkswagen");
        Supplier<Vehicle> volksWgenSupplier = () -> volkswagen;

        Supplier<Vehicle> audSupplier = () -> {
            Vehicle audi = new Vehicle();
            audi.setName("Audi");
            return audi;
        };
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        if(randomNumber % 2 == 0){
            context.registerBean("volks", Vehicle.class, volksWgenSupplier);
        }else{
            context.registerBean("audi", Vehicle.class, audSupplier);
        }

        Vehicle volksVehicle = null;
        Vehicle audVehicle = null;
        try {
            volksVehicle = context.getBean("volks",Vehicle.class);
            System.out.println(" CONDITIONAL "+volksVehicle.getName());
        } catch (NoSuchBeanDefinitionException e) {
            audVehicle = context.getBean("audi",Vehicle.class);
            System.out.println(" CONDITIONAL "+audVehicle.getName());
        }

        context.close();
    }
}