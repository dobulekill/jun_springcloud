/*
 * Copyright (c) 2018. zscatcloud.net All Rights Reserved.
 * 项目名称：zscatcloud快速搭建企业级分布式微服务平台
 * 类名称：DateUtil.java
 * 创建人：刘兆明
 * 联系方式：zscatcloud.net@gmail.com
 * 开源地址: https://github.com/zscatcloud
 * 博客地址: http://blog.zscatcloud.net
 * 项目官网: http://zscatcloud.net
 */

package com.zscatcloud;


import com.xiaoleilu.hutool.date.DateField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * The class Date util.
 *
 * @author Wujun
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {

	/**
	 * 获取系统前时间.
	 *
	 * @param minute the minute
	 *
	 * @return the before time[yyyy-MM-dd HH:mm:ss]
	 */
	public static String getBeforeTime(int minute) {
		Date newDate = com.xiaoleilu.hutool.date.DateUtil.offset(new Date(), DateField.MINUTE, -minute);
		return com.xiaoleilu.hutool.date.DateUtil.formatDateTime(newDate);
	}
}
