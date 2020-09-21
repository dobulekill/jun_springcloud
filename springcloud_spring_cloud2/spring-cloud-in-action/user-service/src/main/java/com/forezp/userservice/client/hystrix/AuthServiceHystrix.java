package com.forezp.userservice.client.hystrix;

import com.forezp.userservice.client.AuthServiceClient;
import com.forezp.userservice.pojo.JWT;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceHystrix implements AuthServiceClient {
    @Override
    public JWT getToken(String authorization, String grantType, String username, String password) {
        System.out.println("----------opps getToken hystrix-----------");
        return null;
    }

    @Override
    public String testRest(String name) {
        System.out.println("AuthServiceHystrix:name:"+name);
        return null;
    }
}
