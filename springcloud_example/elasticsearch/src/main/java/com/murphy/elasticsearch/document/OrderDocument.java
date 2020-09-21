package com.murphy.elasticsearch.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author dongsufeng
 * @date 2020/1/3 17:01
 * @version 1.0
 */
@Data
@Document(indexName = "order",type ="order_info" )
public class OrderDocument implements Serializable {
	@Id
	private Long id;
	@Field(type = FieldType.Text,analyzer = "ik_max_word")
	private String desc;
	@Field(type = FieldType.Long)
	private Date createTime=new Date();
	@Field(type = FieldType.Long)
	private Date updateTime=new Date();
}
