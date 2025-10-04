package com.bobs.spring.core.spring_core_devs4js.qualifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Avion implements Volador{
    private static final Logger log = LoggerFactory.getLogger(Pajaro.class);
    @Override
    public void volar() {
        log.info("Soy un avion y estoy volando");
    }
    
}
