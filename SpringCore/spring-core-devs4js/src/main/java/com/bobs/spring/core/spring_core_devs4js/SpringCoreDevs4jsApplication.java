package com.bobs.spring.core.spring_core_devs4js;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.bobs.spring.core.spring_core_devs4js.atributo.Coche;
import com.bobs.spring.core.spring_core_devs4js.atributo.Motor;
import com.bobs.spring.core.spring_core_devs4js.autowire.AreaCalculatorService;
import com.bobs.spring.core.spring_core_devs4js.constructor.Guitarra;
import com.bobs.spring.core.spring_core_devs4js.profiles.EnvioromentService;
import com.bobs.spring.core.spring_core_devs4js.qualifiers.Animal;
import com.bobs.spring.core.spring_core_devs4js.qualifiers.Nido;
import com.bobs.spring.core.spring_core_devs4js.qualifiers.Perro;
import com.bobs.spring.core.spring_core_devs4js.scope.EjemploService;
import com.bobs.spring.core.spring_core_devs4js.setters.Mueble;

@SpringBootApplication
public class SpringCoreDevs4jsApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringCoreDevs4jsApplication.class);

	public static void main(String[] args) {
		// Hereda de aplicationcontext
		ConfigurableApplicationContext context= SpringApplication.run(SpringCoreDevs4jsApplication.class, args);
		// Esto es sin utilizar inyeccion de dependencias
		// Motor motor = new Motor("XL1",1981);
		// Coche coche = new Coche("VW",1986,motor);
		// System.out.println(coche);

		// El contexto es donde viven los objetos 
		Coche coche = context.getBean(Coche.class);
		System.out.println(coche);
		System.out.println();
		Guitarra guitarra = context.getBean(Guitarra.class);
		System.out.println(guitarra);
		System.out.println();

		Mueble mueble = context.getBean(Mueble.class);
		System.out.println(mueble);
		System.out.println();

		Perro perro = context.getBean(Perro.class);
		log.info("Objeto perro {}", perro.getNombre());
		System.out.println();

		// Que pasa si hay multiples implementaciones de animal?
		// Animal animal = context.getBean(Animal.class);
		// Utilizaremos esta carga
		Animal animal = context.getBean("pajarito",Animal.class);
		log.info("Animal nombre = {} edad= {}", animal.getNombre(), animal.getNombre());

		System.out.println();

		Nido nimdo = context.getBean(Nido.class);
		nimdo.imprimir();
		System.out.println();
		// PROFILES

		EnvioromentService envioromentService = context.getBean(EnvioromentService.class);
		log.info("Enviroment type : {}", envioromentService.getEnviroment());
		System.out.println();

		EjemploService service = context.getBean(EjemploService.class);
		EjemploService service2 = context.getBean(EjemploService.class);

		log.info("Are beans equals ? {}", service.equals(service2));
		log.info("Are beans equals ? {}", service == service2);

		String nombre = context.getBean(String.class);
		System.out.println();
		log.info("Nombre {}", nombre);
		System.out.println();
		AreaCalculatorService area = context.getBean(AreaCalculatorService.class);
		log.info("Area total {}", area.calcAreas());

	}

	@Bean
	public String getApplicationName(){
		return "Israel";
	}

}
