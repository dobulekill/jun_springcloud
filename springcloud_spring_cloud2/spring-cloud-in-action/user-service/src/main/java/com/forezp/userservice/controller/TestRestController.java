package com.forezp.userservice.controller;

import com.forezp.userservice.client.AuthServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestRestController {

    @Autowired
    AuthServiceClient authServiceClient;

    @GetMapping("/hi/{name}")
    public String hi(@PathVariable("name") String name){
        System.out.println("userservice:TestRestController:hi:name:"+name);
        String result=authServiceClient.testRest(name);
        return result;
    }
}
