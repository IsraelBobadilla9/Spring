package com.bobadilla.spring.portaljob.spring_pure_jobportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.bobadilla.spring.portaljob.spring_pure_jobportal.entity.Users;
import com.bobadilla.spring.portaljob.spring_pure_jobportal.entity.UsersTypeE;
import com.bobadilla.spring.portaljob.spring_pure_jobportal.services.UsersService;
import com.bobadilla.spring.portaljob.spring_pure_jobportal.services.UsersTypeService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UsersController {

    private final UsersTypeService usersTypeService;
    private final UsersService usersService;

    @Autowired // no necesario
    public UsersController(UsersTypeService usersTypeService,UsersService usersService){
        this.usersTypeService = usersTypeService;
        this.usersService = usersService;
    }
    // users registration form
    @GetMapping("/register")
    public String register(Model model){
        List<UsersTypeE> usersTypes = usersTypeService.getAll();
        model.addAttribute("getAllTypes", usersTypes);
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register/new")
    public String userRegistration(@Valid Users users, Model model){
        
        System.out.println("User:: "+users);
        Optional<Users> optinalUsers=  usersService.getUserByEmail(users.getEmail());
        if(optinalUsers.isPresent()){
            model.addAttribute("error", "Email already registered, try to login or register with other email");
            List<UsersTypeE> usersTypes = usersTypeService.getAll();
            model.addAttribute("getAllTypes", usersTypes);
            model.addAttribute("user", new Users());
            return "register";
        }
        usersService.addNew(users);
        return "dashboard";
    }
    
}
