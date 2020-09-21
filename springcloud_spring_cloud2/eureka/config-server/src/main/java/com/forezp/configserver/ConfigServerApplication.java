package com.forezp.configserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigServer
//@EnableEurekaClient
@RestController
public class ConfigServerApplication {

    @Value("foo1")
    String foo1;
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

    @GetMapping("/testConfig")
    public String testConfig(){
        System.out.println("config server:"+foo1);
        return foo1;
    }
}
