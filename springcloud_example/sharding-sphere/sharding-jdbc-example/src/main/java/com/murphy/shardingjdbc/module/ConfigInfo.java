package com.murphy.shardingjdbc.module;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author dongsufeng
 * @date 2019/12/6 10:48
 * @version 1.0
 */
@Data
public class ConfigInfo implements Serializable {

	private Long id;
	private String name;
}