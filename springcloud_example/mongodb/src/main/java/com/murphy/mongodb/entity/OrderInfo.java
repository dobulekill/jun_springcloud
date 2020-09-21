package com.murphy.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author dongsufeng
 * @date 2020/1/7 17:24
 * @version 1.0
 */
@Data
@Document(collection = "order_info")
public class OrderInfo implements Serializable {
	@Id
	private Long id;
	private String desc;
	@Field(targetType=FieldType.INT64)
	private Date createTime=new Date();
	private Date updateTime=new Date();
	@Field(value = "id")
	private String orderNo;
}
