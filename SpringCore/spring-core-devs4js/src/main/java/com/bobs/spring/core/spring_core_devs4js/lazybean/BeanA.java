package com.bobs.spring.core.spring_core_devs4js.lazybean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Lazy
public class BeanA {

    private static final Logger log = LoggerFactory.getLogger(BeanA.class);

    @PostConstruct
    public void init(){
        log.info("----> INIT BEAN A");
    }



}
