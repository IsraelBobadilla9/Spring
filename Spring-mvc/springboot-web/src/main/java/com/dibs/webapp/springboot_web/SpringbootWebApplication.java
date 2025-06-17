package com.dibs.webapp.springboot_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
// agregar archivos extra al properties
// @PropertySources({
// 	@PropertySource("classpath:values.properties")
// 	//@PropertySource("classpath:values2.properties")
// })
public class SpringbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebApplication.class, args);
	}

}
