/*
 * Copyright (c) 2018. zscatcloud.net All Rights Reserved.
 * 项目名称：zscatcloud快速搭建企业级分布式微服务平台
 * 类名称：LogAnnotation.java
 * 创建人：刘兆明
 * 联系方式：zscatcloud.net@gmail.com
 * 开源地址: https://github.com/zscatcloud
 * 博客地址: http://blog.zscatcloud.net
 * 项目官网: http://zscatcloud.net
 */

package com.zscatcloud.core.annotation;

import com.zscatcloud.core.enums.LogTypeEnum;

import java.lang.annotation.*;


/**
 * 操作日志.
 *
 * @author Wujun
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
	/**
	 * 日志类型
	 *
	 * @return the log type enum
	 */
	LogTypeEnum logType() default LogTypeEnum.OPERATION_LOG;

	/**
	 * 是否保存请求的参数
	 *
	 * @return the boolean
	 */
	boolean isSaveRequestData() default false;

	/**
	 * 是否保存响应的结果
	 *
	 * @return the boolean
	 */
	boolean isSaveResponseData() default false;
}
