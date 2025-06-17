package com.danbobadilla9.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HolaController {
	
	@GetMapping("/")
	public String home() {
		//return "redirect:/app/index";
		return "forward:/app/index";
	}
	
}
