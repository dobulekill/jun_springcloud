package com.forezp.adminservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${spring.application.name}")
    String hostname;

    @RequestMapping("/sayHello")
    public String sayHello(){
        return "Hi,i'm forezp!"+hostname;
    }
}
