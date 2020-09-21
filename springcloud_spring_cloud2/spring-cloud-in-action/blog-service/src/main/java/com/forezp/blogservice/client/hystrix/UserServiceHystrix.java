package com.forezp.blogservice.client.hystrix;

import com.forezp.blogservice.client.UserServiceClient;
import com.forezp.blogservice.pojo.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystrix implements UserServiceClient {

    @Override
    public ResponseEntity<User> getUser(String authorization, String username) {
        System.out.println(authorization);
        System.out.println(username);
        return null;
    }
}
