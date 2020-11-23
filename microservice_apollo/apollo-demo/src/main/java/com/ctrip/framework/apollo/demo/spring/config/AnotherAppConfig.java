package com.ctrip.framework.apollo.demo.spring.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

import org.springframework.context.annotation.Configuration;

/**
 * @author Wujun
 */
@Configuration
@EnableApolloConfig(value = "FX.apollo", order = 11)
public class AnotherAppConfig {
}
