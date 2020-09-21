package com.murphy.shardingjdbc.module;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author dongsufeng
 * @date 2019/12/5 16:38
 * @version 1.0
 */
@Data
public class User implements Serializable {

	private Long id;
	private String name;
}
