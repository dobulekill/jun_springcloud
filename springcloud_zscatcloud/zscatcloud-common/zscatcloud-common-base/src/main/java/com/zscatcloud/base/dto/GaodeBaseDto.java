/*
 * Copyright (c) 2018. zscatcloud.net All Rights Reserved.
 * 项目名称：zscatcloud快速搭建企业级分布式微服务平台
 * 类名称：GaodeBaseDto.java
 * 创建人：刘兆明
 * 联系方式：zscatcloud.net@gmail.com
 * 开源地址: https://github.com/zscatcloud
 * 博客地址: http://blog.zscatcloud.net
 * 项目官网: http://zscatcloud.net
 */
package com.zscatcloud.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * The class Gaode base dto.
 *
 * @author Wujun
 */
@Data
@ApiModel
public class GaodeBaseDto implements Serializable{

	private static final long serialVersionUID = 5894304327211503218L;
	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态")
	private String status;

	/**
	 * 响应信息
	 */
	@ApiModelProperty(value = "响应信息")
	private String info;

	/**
	 * 响应编码
	 */
	@ApiModelProperty(value = "响应编码")
	private String infocode;
}
