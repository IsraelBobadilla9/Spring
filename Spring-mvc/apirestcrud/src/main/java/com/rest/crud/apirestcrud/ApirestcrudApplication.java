package com.rest.crud.apirestcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:messages.properties")
public class ApirestcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApirestcrudApplication.class, args);
	}

}
