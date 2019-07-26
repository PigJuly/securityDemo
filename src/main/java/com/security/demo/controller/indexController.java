package com.security.demo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class indexController {


    @GetMapping("/home/index1")
    @Secured("ROLE_USER")
    public String test1(){
        return "hello jenkins1";
    }


    @GetMapping("/home/index2")
    @Secured("ROLE_ADMIN")
    public String test2(){
        return "hello jenkins2";
    }
}
