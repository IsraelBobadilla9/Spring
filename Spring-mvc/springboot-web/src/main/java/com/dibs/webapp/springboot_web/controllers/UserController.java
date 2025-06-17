package com.dibs.webapp.springboot_web.controllers;

import com.dibs.webapp.springboot_web.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// controller indica que vamos a trabajar con vistas html
@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Map<String, Object> model){ // aqui spring nos injecta una instancia para pasar datos a la vista
//    public String details(Model model){ // aqui spring nos injecta una instancia para pasar datos a la vista

//        model.addAttribute("title","Hola mundo Spring boot");
//        model.addAttribute("name","Israel");
//        model.addAttribute("lastname","Segundo");
        User user = new User("Israel","Segundo");
//        user.setEmail(null);

        model.put("title","Hola mundo Spring boot");
        model.put("user",user);


        return "details";
        // es el nombre de la vista
    }


    @GetMapping("/list")
    public String list(ModelMap model){




//        model.addAttribute("users",users);
        model.addAttribute("tittle","listas en thymeleaf");
        return "list";
    }


    // es un valor por default que se le pasa a nuestra vista en caso de que no se le pase al momento de regresar la vista
    @ModelAttribute("users")
    public List<User> usersModel(){
        return Arrays.asList(new User("israel","segundo","buenas@hotmail.com"),
                new User("dan","segundo"),
                new User("bobadilla","segundo"));
    }



}
