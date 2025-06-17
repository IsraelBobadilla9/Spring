package com.springmicro.items.itemsmsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ItemsmsvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemsmsvcApplication.class, args);
	}

}
