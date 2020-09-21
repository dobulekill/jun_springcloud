package com.forezp.userservice.controller;

import com.forezp.userservice.service.AuthServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    AuthServiceClient authServiceClient;

    @GetMapping("/hi")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String hi(){
        return authServiceClient.testHi();
    }
}
