package com.security.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class LoansController {
    @GetMapping("/myLoans")
    public String getLoansDetails(@RequestParam String param) {
        return "here are the loans details from the db";
    }
    
}
