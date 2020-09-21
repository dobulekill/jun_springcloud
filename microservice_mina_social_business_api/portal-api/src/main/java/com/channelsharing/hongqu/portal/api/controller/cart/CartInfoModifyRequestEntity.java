/**
 * Copyright &copy; 2016-2022 liuhangjun All rights reserved.
 */
package com.channelsharing.hongqu.portal.api.controller.cart;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * 购物车Entity
 * @author liuhangjun
 * @version 2018-06-22
 */
@Data
public class CartInfoModifyRequestEntity {

    @ApiModelProperty(value = "id", example = "1")
    @NotNull
	public Long id;
	
	
	@ApiModelProperty(value = "商品数量", example = "2")
	@Range(min=1, max=999, message="商品数量必须介于 1 和 999 之间")
	public Integer goodsNumber;		// 商品数量
	


}
