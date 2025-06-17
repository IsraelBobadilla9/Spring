package com.security.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ContactController {

    @GetMapping("/contact")
    public String saveContactInquiryDetails() {
        return "here are the card details from the db";
    }
    
    
}