/*
 * Copyright (c) 2018. zscatcloud.net All Rights Reserved.
 * 项目名称：zscatcloud快速搭建企业级分布式微服务平台
 * 类名称：BooleanParseException.java
 * 创建人：刘兆明
 * 联系方式：zscatcloud.net@gmail.com
 * 开源地址: https://github.com/zscatcloud
 * 博客地址: http://blog.zscatcloud.net
 * 项目官网: http://zscatcloud.net
 */
package com.zscatcloud.base.exception;

/**
 * The class Boolean parse exception.
 *
 * @author zscatcloud.net@gmail.com
 */
public class BooleanParseException extends RuntimeException {

	/**
	 * Instantiates a new Boolean parse exception.
	 */
	public BooleanParseException() {
		super();
	}

	/**
	 * Instantiates a new Boolean parse exception.
	 *
	 * @param message the message
	 */
	public BooleanParseException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new Boolean parse exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 */
	public BooleanParseException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new Boolean parse exception.
	 *
	 * @param cause the cause
	 */
	public BooleanParseException(Throwable cause) {
		super(cause);
	}

}
