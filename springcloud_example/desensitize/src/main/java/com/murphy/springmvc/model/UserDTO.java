package com.murphy.springmvc.model;

import com.murphy.springmvc.annotation.Desensitization;
import com.murphy.springmvc.enums.DesensitionType;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author dongsufeng
 * @date 2019/12/18 18:14
 * @version 1.0
 */
@Data
public class UserDTO implements Serializable {
	@Desensitization(type=DesensitionType.IDENTITYNO)
	private String identityNo;
	private String name;
	private String realname;
}
