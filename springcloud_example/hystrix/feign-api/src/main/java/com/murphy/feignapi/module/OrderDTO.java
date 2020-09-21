package com.murphy.feignapi.module;/**
 * @author dongsufeng
 * @date 2019/11/27 11:16
 * @version 1.0
 */

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author dongsufeng
 * @date 2019/11/27 11:16
 * @version 1.0
 */
@Data
public class OrderDTO implements Serializable {

	private String orderNo;

	private UserDTO userDTO;
}
