/*
 * Copyright (c) 2018. zscatcloud.net All Rights Reserved.
 * 项目名称：zscatcloud快速搭建企业级分布式微服务平台
 * 类名称：OAuth2Properties.java
 * 创建人：刘兆明
 * 联系方式：zscatcloud.net@gmail.com
 * 开源地址: https://github.com/zscatcloud
 * 博客地址: http://blog.zscatcloud.net
 * 项目官网: http://zscatcloud.net
 */

package com.zscatcloud.security.core.properties;

import lombok.Data;

/**
 * The class O auth 2 properties.
 *
 * @author Wujun
 */
@Data
public class OAuth2Properties {

	/**
	 * 使用jwt时为token签名的秘钥
	 */
	private String jwtSigningKey = "zscatcloud";
	/**
	 * 客户端配置
	 */
	private OAuth2ClientProperties[] clients = {};

}
