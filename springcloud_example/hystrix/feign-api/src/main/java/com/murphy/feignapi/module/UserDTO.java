package com.murphy.feignapi.module;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author Wujun
 * @date 2019/11/27 10:56
 * @version 1.0
 */
@Data
public class UserDTO implements Serializable {
	private String userId;
	private String username;
}
