package com.dibs.webapp.springboot_web.controllers;

import com.dibs.webapp.springboot_web.models.User;
import com.dibs.webapp.springboot_web.models.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


// ESTO FORMA PARTE DEL MVC  Modelo: consulta a la base de datos  Vista: la vista es el JSON y Controlador: interactua con los datos y regresa los datos a la vista

// controller indica que vamos a trabajar con vistas html
@RestController // responsebody  regresa todo en formato json ya que spring web se integra con json utilizando JACKSON
// se puede utilizar Controller y el GetMapping se tiene que cambiar a responsebody, la ventaja es que tendremos un controlador con vistas y json
@RequestMapping("/api")
public class UserRestController {

    //@GetMapping("/details")
    @RequestMapping(path = "/details", method = RequestMethod.GET)// por defecto es de tipo get y permite mapear una ruta
    public Map<String,Object> details(){

        User user = new User("Israel","Segundo");

        Map<String,Object> body = new HashMap<>();
        body.put("title","Hola mundo spring boot ");
        body.put("user",user);
        return body;
    }

    @RequestMapping(path = "/details2", method = RequestMethod.GET)
    public UserDto details2(){

        User user = new User("Israel","Segundo");
        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTittle("Hola mundo spring boot ");


        return userDto;
    }
    @GetMapping("/list")
    public List<User> list(){
        User user = new User("Israel","Segundo");
        User user2 = new User("Dan","Segundo");
        User user3 = new User("Bobadilla","Segundo");
        User user4 = new User("JOse","Segundo");

//        List<User> users = new ArrayList<>();
//        users.add(user);
//        users.add(user2);
//        users.add(user3);
//        users.add(user4);

        List<User> users = Arrays.asList(user,user2,user3,user4);

        return users;
    }



}
