/*
 * Copyright (c) 2018. zscatcloud.net All Rights Reserved.
 * 项目名称：zscatcloud快速搭建企业级分布式微服务平台
 * 类名称：Oauth2ClientProperties.java
 * 创建人：刘兆明
 * 联系方式：zscatcloud.net@gmail.com
 * 开源地址: https://github.com/zscatcloud
 * 博客地址: http://blog.zscatcloud.net
 * 项目官网: http://zscatcloud.net
 */

package com.zscatcloud.security.feign;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The class Oauth 2 client properties.
 *
 * @author Wujun
 */
@Data
@ConfigurationProperties(prefix = "zscatcloud.oauth2.client")
public class Oauth2ClientProperties {
	private String id;
	private String accessTokenUrl;
	private String clientId;
	private String clientSecret;
	private String clientAuthenticationScheme;
}

