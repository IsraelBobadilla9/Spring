package com.bobs.spring.core.spring_core_devs4js.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
// cambiamos el scope
@Scope("prototype")
public class EjemploService {
    
}
