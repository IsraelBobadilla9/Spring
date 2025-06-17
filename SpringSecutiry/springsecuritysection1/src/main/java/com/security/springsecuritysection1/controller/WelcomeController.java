package com.security.springsecuritysection1.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class WelcomeController {
    
    @GetMapping("/welcome")
    public String sayWelcome(){
        return "Welcome to Spring Application wiht security";
    }
    
    
}
