package com.forezp.userservice.service;

import com.forezp.userservice.pojo.JWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceHystrix implements AuthServiceClient {
    Logger logger=LoggerFactory.getLogger(AuthServiceHystrix.class);
    @Override
    public JWT getToken(String authorization, String grantType, String username, String password) {
        logger.error("get token has exception");
        return null;
    }

    @Override
    public String testHi() {
        logger.error("test hi");
        return null;
    }
}
