/*
 * Copyright (c) 2018. zscatcloud.net All Rights Reserved.
 * 项目名称：zscatcloud快速搭建企业级分布式微服务平台
 * 类名称：Query.java
 * 创建人：刘兆明
 * 联系方式：zscatcloud.net@gmail.com
 * 开源地址: https://github.com/zscatcloud
 * 博客地址: http://blog.zscatcloud.net
 * 项目官网: http://zscatcloud.net
 */

package com.zscatcloud.page;

import lombok.Data;

import java.io.Serializable;

/**
 * The class Query.
 *
 * @author zscatcloud.net@gmail.com
 */
@Data
public class Query implements Serializable {
	private static final long serialVersionUID = 8933019121780323520L;
	/**
	 * 当前页
	 */
	private int pageNum = 1;
	/**
	 * 每页的数量
	 */
	private int pageSize = 20;
}
