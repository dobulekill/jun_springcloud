package com.forezp.eurekaclientone.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Value("${server.port}")
    String port;

    @GetMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(@RequestParam String name){
        return "hi "+name+",i am lucy and from port:"+port;
    }

    public String hiError(String name){
        return "hi,"+name+",sorry,eorr!";
    }

    @ApiOperation(value = "test User service", notes = "test user service")
    @GetMapping("/testUser")
    public String testUser(){
        return "testUser";
    }
}
