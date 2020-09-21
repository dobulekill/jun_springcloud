package com.forezp.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class CheckPropertiesController {

    @Value("${foo}")
    String foo;

    @Value("${hello}")
    String hello;

    @Value("${hello1}")
    String hello1;

    @GetMapping("/hello")
    public String hello(){
        System.out.println("hello config-client:"+foo);
        System.out.println("hello config-client:"+hello1);
        System.out.println("hello config-client:"+hello);
        return foo;
    }
}
