/*
 * Copyright (c) 2018. zscatcloud.net All Rights Reserved.
 * 项目名称：zscatcloud快速搭建企业级分布式微服务平台
 * 类名称：HttpAesException.java
 * 创建人：刘兆明
 * 联系方式：zscatcloud.net@gmail.com
 * 开源地址: https://github.com/zscatcloud
 * 博客地址: http://blog.zscatcloud.net
 * 项目官网: http://zscatcloud.net
 */

package com.zscatcloud.exception;


/**
 * The class Http aes exception.
 *
 * @author Wujun
 */
public class HttpAesException extends IllegalArgumentException {
	private static final long serialVersionUID = -2489600753056921095L;

	/**
	 * Instantiates a new Http aes exception.
	 *
	 * @param message the message
	 */
	public HttpAesException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new Http aes exception.
	 */
	public HttpAesException() {

	}
}
