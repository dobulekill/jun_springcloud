/*
 * Copyright (c) 2018. zscatcloud.net All Rights Reserved.
 * 项目名称：zscatcloud快速搭建企业级分布式微服务平台
 * 类名称：RegisterDto.java
 * 创建人：刘兆明
 * 联系方式：zscatcloud.net@gmail.com
 * 开源地址: https://github.com/zscatcloud
 * 博客地址: http://blog.zscatcloud.net
 * 项目官网: http://zscatcloud.net
 */

package com.zscatcloud.core.registry.base;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The class Register dto.
 *
 * @author Wujun
 */
@Data
@AllArgsConstructor
public class RegisterDto {

	private String app;

	private String host;

	private CoordinatorRegistryCenter coordinatorRegistryCenter;

}
