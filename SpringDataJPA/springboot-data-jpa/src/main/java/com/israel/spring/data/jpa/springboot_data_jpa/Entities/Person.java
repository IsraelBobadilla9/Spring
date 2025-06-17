package com.israel.spring.data.jpa.springboot_data_jpa.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// Entity es de hibernate y JPA 
@Entity
// table es opcional, si no se usa se utiliza el mismo nombre que la clase 
@Table(name = "persons", schema = "db_springboot")
public class Person {
    

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String lastname;
    @Column(name = "programming_language")
    private String programmingLanguage;

    // si hay un cosntructor personalizado necesitamos un constructor vacio ya que lo utiliza jpa para crear la instancia 
    public Person(){

    }

    public Person(Long id, String name, String lastname, String programmingLanguage) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.programmingLanguage = programmingLanguage;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", lastname=" + lastname + ", programmingLanguage="
                + programmingLanguage + "]";
    }

    
    


}
