/*
 * Copyright (c) 2018. zscatcloud.net All Rights Reserved.
 * 项目名称：zscatcloud快速搭建企业级分布式微服务平台
 * 类名称：ValidateCodeProcessorHolder.java
 * 创建人：刘兆明
 * 联系方式：zscatcloud.net@gmail.com
 * 开源地址: https://github.com/zscatcloud
 * 博客地址: http://blog.zscatcloud.net
 * 项目官网: http://zscatcloud.net
 */

package com.zscatcloud.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 校验码处理器管理器
 *
 * @author zscatcloud.net @gmail.com
 */
@Component
public class ValidateCodeProcessorHolder {

	private final Map<String, ValidateCodeProcessor> validateCodeProcessors;

	/**
	 * Instantiates a new Validate code processor holder.
	 *
	 * @param validateCodeProcessors the validate code processors
	 */
	@Autowired
	public ValidateCodeProcessorHolder(Map<String, ValidateCodeProcessor> validateCodeProcessors) {
		this.validateCodeProcessors = validateCodeProcessors;
	}

	/**
	 * Find validate code processor validate code processor.
	 *
	 * @param type the type
	 *
	 * @return validate code processor
	 */
	ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
		return findValidateCodeProcessor(type.toString().toLowerCase());
	}

	/**
	 * Find validate code processor validate code processor.
	 *
	 * @param type the type
	 *
	 * @return validate code processor
	 */
	ValidateCodeProcessor findValidateCodeProcessor(String type) {
		String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
		ValidateCodeProcessor processor = validateCodeProcessors.get(name);
		if (processor == null) {
			throw new ValidateCodeException("验证码处理器" + name + "不存在");
		}
		return processor;
	}

}