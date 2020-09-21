package com.forezp.userservice.client;

import com.forezp.userservice.client.hystrix.AuthServiceHystrix;
import com.forezp.userservice.pojo.JWT;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "uaa-service",fallback = AuthServiceHystrix.class)
public interface AuthServiceClient {

    @PostMapping("/oauth/token")
    JWT getToken(@RequestHeader("Authorization")String authorization,
                 @RequestParam("grant_type")String grantType,
                 @RequestParam("username")String username,
                 @RequestParam("password")String password);
    @GetMapping("/test/hi/{name}")
    String testRest(@PathVariable(value = "name") String name);
}
