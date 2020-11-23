package com.murphy.springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.murphy.springmvc.exception.BusinessExcetpion;
import com.murphy.springmvc.exception.LoginException;
import com.murphy.springmvc.model.ResponseDTO;
import com.murphy.springmvc.model.UserDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wujun
 * @date 2019/12/18 17:09
 * @version 1.0
 */
@RestController
@Log4j2
public class LoginController {
	@PostMapping("/login")
	public ResponseDTO<Boolean> login(){
		throw new LoginException("用户名密码错误");
	}
	@GetMapping("/business")
	public ResponseDTO<Boolean> business(){
		throw new BusinessExcetpion("业务错了");
	}
	@GetMapping("/idNo")
	public ResponseDTO<UserDTO> getIdNo(){
		UserDTO userDTO=new UserDTO();
		userDTO.setIdentityNo("111111111111111111");
		userDTO.setName("dsf");
		userDTO.setRealname("张三");
		log.info("==============realname={}",userDTO.getRealname());
		log.info("===============userDTO.toString={}",userDTO.toString());
		log.info("===============userDTO.fastjson={}", JSON.toJSONString(userDTO));
		return new ResponseDTO<UserDTO>().build(userDTO);
	}
}
