package com.israel.spring.data.jpa.springboot_data_jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.israel.spring.data.jpa.springboot_data_jpa.Entities.Person;
import com.israel.spring.data.jpa.springboot_data_jpa.Repositories.PersonRepository;

@SpringBootApplication
// se agrega command line porque no utilizaremos servicios web 
public class SpringbootDataJpaApplication implements CommandLineRunner{

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		findOne();
		
	}

	public void findOne(){
		Person person = null;
		Optional<Person> optionalPerson = repository.findById(20L);
		if(optionalPerson.isPresent()){
			System.out.println("Person "+person);
		}else{
			System.out.println("NO PERSON FOUND");
		}

		repository.findById(2L).ifPresent(p -> System.out.println(p));


	}

	public void list(){
		System.out.println("MOSTRANDO INFORMACION ");
		List<Person> persons = (List<Person>) repository.findAll();
		List<Person> personsFilter = repository.findByProgrammingLanguage("Java");
		List<Person> personsFilterNameProg = repository.buscarByProgrammingLanguage("Java","Maria");
		List<Person> personsFilterQueryMethod = repository.findByProgrammingLanguageAndName("Java","Maria");

		
		persons.stream().forEach(p -> System.out.println(p));

		System.out.println("FILTER BY JAVA 	");
		personsFilter.stream().forEach(f -> System.out.println(f));
		System.out.println("FILTER BY JAVA 	AND MARIA ");
		personsFilterNameProg.stream().forEach(f -> System.out.println(f));
		System.out.println("QUERYMETHOD ");
		personsFilterQueryMethod.stream().forEach(f -> System.out.println(f));

		List<Object[]> personValues = repository.obtenerPersonData();
		System.out.println("CONSULTA MODIFICADA CON COLUMNAS ESPECIFICAS");
		personValues.stream().forEach(person -> {
			System.out.println("Name : "+person[0]+ " Lenguaje Prog "+person[1]);
		});
	}

}
