/*
 * Copyright (c) 2018. zscatcloud.net All Rights Reserved.
 * 项目名称：zscatcloud快速搭建企业级分布式微服务平台
 * 类名称：EmailCodeProperties.java
 * 创建人：刘兆明
 * 联系方式：zscatcloud.net@gmail.com
 * 开源地址: https://github.com/zscatcloud
 * 博客地址: http://blog.zscatcloud.net
 * 项目官网: http://zscatcloud.net
 */

package com.zscatcloud.security.core.properties;

import lombok.Data;

/**
 * The class Email code properties.
 *
 * @author Wujun
 */
@Data
public class EmailCodeProperties {

	/**
	 * 过期时间
	 */
	private int expireIn = 60 * 60 * 24;
	/**
	 * 要拦截的url，多个url用逗号隔开，ant pattern
	 */
	private String url;

}
