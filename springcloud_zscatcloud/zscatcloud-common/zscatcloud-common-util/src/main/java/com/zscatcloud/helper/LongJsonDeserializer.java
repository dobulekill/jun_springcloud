/*
 * Copyright (c) 2018. zscatcloud.net All Rights Reserved.
 * 项目名称：zscatcloud快速搭建企业级分布式微服务平台
 * 类名称：LongJsonDeserializer.java
 * 创建人：刘兆明
 * 联系方式：zscatcloud.net@gmail.com
 * 开源地址: https://github.com/zscatcloud
 * 博客地址: http://blog.zscatcloud.net
 * 项目官网: http://zscatcloud.net
 */

package com.zscatcloud.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 将字符串转为Long
 *
 * @author zscatcloud.net@gmail.com
 */
@Slf4j
public class LongJsonDeserializer extends JsonDeserializer<Long> {

	/**
	 * Deserialize long.
	 *
	 * @param jsonParser             the json parser
	 * @param deserializationContext the deserialization context
	 *
	 * @return the long
	 */
	@Override
	public Long deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
		String value = null;
		try {
			value = jsonParser.getText();
		} catch (IOException e) {
			log.error("deserialize={}", e.getMessage(), e);
		}
		try {
			return value == null ? null : Long.parseLong(value);
		} catch (NumberFormatException e) {
			log.error("解析长整形错误", e);
			return null;
		}
	}
}