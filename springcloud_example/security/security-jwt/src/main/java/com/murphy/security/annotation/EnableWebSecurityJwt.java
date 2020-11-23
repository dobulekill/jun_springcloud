package com.murphy.security.annotation;

import java.lang.annotation.*;

import org.springframework.context.annotation.Import;

import com.murphy.security.config.WebSecurityConfig;

/**
 * 使用前需要在启动类上加此注解
 * @author Wujun
 * @date 2019/12/02 16:28
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({WebSecurityConfig.class})
public @interface EnableWebSecurityJwt {

}
