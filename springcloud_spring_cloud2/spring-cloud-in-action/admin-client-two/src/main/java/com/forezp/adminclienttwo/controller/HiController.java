package com.forezp.adminclienttwo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class HiController {

    @Value("${server.port}")
    String port;

    @HystrixCommand(fallbackMethod = "hiError")
    @RequestMapping("/hi")
    public String hi(@RequestParam String name){
        return "hi,"+name+"i'm from port:"+port;
    }

    public String hiError(String name){
        return "hi,"+name+":has error";
    }
}
