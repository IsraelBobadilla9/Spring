

 package com.dibs.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dibs.webapp.springboot_web.models.User;
import com.dibs.webapp.springboot_web.models.dto.ParamDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.code}")
    private int code;
    @Value("${config.array}")
    private String[] values;
    @Value("${config.array}")
    private List<String> listOfValues;

    // Spring Expression Language SpEL
    @Value("#{ '${config.array}'.split(',')}")
    private String[] spitConfig;

    @Value("#{ '${config.array}'}")
    private String valuesConvertedString;
    
    @Value("#{ ${config.valuesMap} }")
    private Map<String,Object> json;


    @Value("#{ ${config.valuesMap}.product }")
    private String product;

    @Value("#{ ${config.valuesMap}.price }")
    private Long price;


    // siempre es requerido utilizar un pathvariable
    @GetMapping("/baz/{message}")
    public ParamDto getMethodName(@PathVariable(name = "message") String mensaje) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(mensaje);
        return paramDto;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String,Object> mixPathVariableMap(@PathVariable String product, @PathVariable Long id) {
        
        Map<String,Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        
        return json;
    }


    @Autowired
    private Environment environment;
    

    @PostMapping("/create")
    public User creatUser(@RequestBody User user) {        

        return user;
    }

    @GetMapping("/values")
    public Map<String,Object>  getValues(@Value("${config.message}") String message) {
        Map<String,Object> values = new HashMap<>();
        values.put("code", code);
        values.put("values", this.values);
        values.put("message", message);
        values.put("message2", environment.getProperty("config.message"));
        values.put("list", listOfValues);
        values.put("splitValues", spitConfig);
        values.put("stringcomplete", valuesConvertedString);
        values.put("jsonToMap", json);
        values.put("product", product);
        values.put("price", price);
        return values;
    }
    
    
    
    
}












