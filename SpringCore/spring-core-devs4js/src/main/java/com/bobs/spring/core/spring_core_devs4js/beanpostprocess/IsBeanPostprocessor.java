package com.bobs.spring.core.spring_core_devs4js.beanpostprocess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.bobs.spring.core.spring_core_devs4js.lifecycle.LifeCycleBean;

// esto sobreescribe todos los eventos que se construyen por spring y con esto podremos saber cuales estan siendo construidos 
@Component
public class IsBeanPostprocessor implements BeanPostProcessor{
    private static final Logger log = LoggerFactory.getLogger(IsBeanPostprocessor.class);
    // Esto tiene metodos que son defualt popr lo que no es obligatorio implementarlos 

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName){
        if(bean instanceof LifeCycleBean){
            log.warn("ESTE ES EL MIO Y AQUI PUEDO TOCARLO ALV ");
        }
        log.info("**********************Before initilization {}",beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName){
        log.info("**********************After  initilization {}",beanName);
        return bean;
    }
}
