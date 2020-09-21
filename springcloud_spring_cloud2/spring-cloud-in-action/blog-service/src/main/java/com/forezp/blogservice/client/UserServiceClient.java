package com.forezp.blogservice.client;

import com.forezp.blogservice.client.hystrix.UserServiceHystrix;
import com.forezp.blogservice.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "user-service",fallback = UserServiceHystrix.class)
public interface UserServiceClient {
    @PostMapping("/user/{username}")
    ResponseEntity<User> getUser(@RequestHeader("Authorization")String authorization,
                                 @PathVariable String username);
}
