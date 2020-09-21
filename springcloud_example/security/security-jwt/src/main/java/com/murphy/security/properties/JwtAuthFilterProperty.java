package com.murphy.security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 过滤器默认配置，可在配置文件自定义
 * @author dongsufeng
 * @date 2019/12/02 15:22
 * @version 1.0
 */
@Data
@Configuration
@Component
@ConfigurationProperties(prefix = "jwt.filter")
public class JwtAuthFilterProperty {

    /**
     * 请求header内的key
     */
    private String header = "Authorization";
    /**
     * 请求header内的key对应value 的默认开头
     */
    private String tokenHead = "Bearer ";
    /**
     * 过滤路径
     * 如 登录接口不需要走校验过滤器
     */
    private String exceptUrl = "";


}
