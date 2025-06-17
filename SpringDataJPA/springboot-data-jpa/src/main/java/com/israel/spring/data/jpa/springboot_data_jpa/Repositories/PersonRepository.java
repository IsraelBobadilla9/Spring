package com.israel.spring.data.jpa.springboot_data_jpa.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.israel.spring.data.jpa.springboot_data_jpa.Entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{
    
    List<Person> findByProgrammingLanguage(String programmingLanguage);
    //consulta nativa a jpa el from es hacia la clase y no la tabla, igual las columnas son las propiedades de la entity
    @Query("SELECT p FROM Person p WHERE p.programmingLanguage=?1 and p.name=?2")
    List<Person> buscarByProgrammingLanguage(String programmingLanguage,String name);
    // query methods
    List<Person> findByProgrammingLanguageAndName(String programmingLanguage,String name);

    @Query("SELECT p.name, p.programmingLanguage FROM Person p")
    List<Object[]> obtenerPersonData();

}


