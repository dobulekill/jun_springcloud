package com.murphy.springmvc.model;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author Wujun
 * @date 2019/12/18 16:55
 * @version 1.0
 */
@Data
public class ResponseDTO<T> implements Serializable {

	private String code;
	private String message;
	private T data;

	public ResponseDTO<T> build(T data){
		this.code="000000";
		this.message="SUCCESS";
		this.data=data;
		return this;
	}
	public ResponseDTO<T> build(String code,String message,T data){
		this.code=code;
		this.message=message;
		this.data=data;
		return this;
	}
}
