package com.bobs.spring.core.spring_core_devs4js.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Lazy
public class LifeCycleBean implements BeanNameAware, InitializingBean, DisposableBean{

    private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);

    // se ejecuta durante la construccion del bean beannameawarre
    @Override
    public void setBeanName(String name) {
        log.info("========= Bean Name {}",name);
    }

    // ejecuta despues de creacion
    @PostConstruct
    public void init(){
        log.info("PostConstruct");
    }
    // ejecuta al destruir

    @PreDestroy// estas son anotaciones 
    public void destroyBean(){
        log.info("Predestroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(":::::::::: After properties set method");
    }

    @Override
    public void destroy() throws Exception {
        // TODO Auto-generated method stub
        log.info("::::::::Destroy method disponsablebean");
    }
    
}
