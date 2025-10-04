package com.bobs.spring.core.spring_core_devs4js.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/hellow-world")
public class HelloWorldController {
    
    @GetMapping    
    public ResponseEntity<String> helloWorld(){
        return new ResponseEntity<>("Hola mundo ",HttpStatus.OK);
    }

}
