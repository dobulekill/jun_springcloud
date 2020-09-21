package com.forezp.userservice.service;

import com.forezp.userservice.pojo.JWT;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "uaa-service",fallback = AuthServiceHystrix.class)
public interface AuthServiceClient {

    @PostMapping("/oauth/token")
    JWT getToken(@RequestHeader("Authorization") String authorization,
                 @RequestParam("grant_type") String grantType,
                 @RequestParam("username") String username,
                 @RequestParam("password") String password);

    @GetMapping("/test/hi")
    String testHi();
}
