package com.murphy.security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 过滤器默认配置，可在配置文件自定义
 * @author dongsufeng
 * @date 2019/12/03 10:01
 * @version 1.0
 */
@Data
@Configuration
@Component
@ConfigurationProperties(prefix = "login.extend")
public class LoginExtendProperty {

    /**
     * 登录用户名
     */
    private String username = "username";
    /**
     * 登录密码
     */
    private String password = "password";
    /**
     * 登录访问地址
     */
    private String loginUrl = "/auth/token";


}
