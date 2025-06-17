package com.dibs.webapp.springboot_web.controllers;

import com.dibs.webapp.springboot_web.models.dto.ParamDto;
import com.dibs.webapp.springboot_web.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "value null", name = "mensaje") String message){
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code){
        ParamMixDto paramDto = new ParamMixDto();

        paramDto.setMessage(text);
        paramDto.setCode(10);

        return paramDto;


    }

    // vamos a obtener los parametros de manera nativa como en jakarta

    @GetMapping("/request")
    public ParamMixDto getMethodName(HttpServletRequest httpServletRequest) {

        Integer code = 0;
        try {
            code = Integer.parseInt(httpServletRequest.getParameter("code"));

        } catch (NumberFormatException e) {
            System.out.println("Error en casteo ");
        }

        ParamMixDto paramDto = new ParamMixDto();
        paramDto.setMessage(httpServletRequest.getParameter("text"));
        paramDto.setCode(code);

        return paramDto;
    }
    

}
