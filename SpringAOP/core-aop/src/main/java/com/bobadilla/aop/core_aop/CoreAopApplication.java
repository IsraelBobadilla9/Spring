package com.bobadilla.aop.core_aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.bobadilla.aop.core_aop.aop.TargetObject;

@SpringBootApplication
public class CoreAopApplication {
	private static final Logger log = LoggerFactory.getLogger(CoreAopApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CoreAopApplication.class, args);
		TargetObject targetObject= context.getBean(TargetObject.class);
		targetObject.hello("Hola desde spring ");
	}

}
