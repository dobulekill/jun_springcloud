package com.murphy.security.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * jwt生成相关配置
 * @author dongsufeng
 * @version 4.0
 * @date 2019/12/2 2:45 PM
 */

@Getter
@Setter
@Configuration
@Component
@ConfigurationProperties(prefix = "jwt.payload")
public class JwtPayloadProperties {

    /**
     * 密钥
     */
    private String secret = "simple";
    /**
     * jwt签发者名称
     */
    private String issuer = "security-jwt";
    /**
     * 接收jwt的一方，可获取登录放机器唯一标识放入header
     */
    private String audience = "foo";
    /**
     * 过期时间 ( 分钟 )
     * 默认是一天
     */
    private int expirationMinute = 24 * 60 * 60;
    /**
     * NotBefore ( 分钟 )生效时间
     * 默认是15分钟
     */
    private int notBeforeMinute = 15;
}
