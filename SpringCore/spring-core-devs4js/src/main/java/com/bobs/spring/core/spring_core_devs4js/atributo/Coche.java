package com.bobs.spring.core.spring_core_devs4js.atributo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Coche {
    @Value("VW")
    private String marca;
    @Value("1")
    private Integer mode;
    @Autowired// Esto es inyeccion de dependencias por atributo
    private Motor motor;

    public Coche() {
    }

    public Coche(String marca, Integer mode, Motor motor) {
        this.marca = marca;
        this.mode = mode;
        this.motor = motor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Coche [marca=" + marca + ", mode=" + mode + ", motor=" + motor + "]";
    }

    

}
