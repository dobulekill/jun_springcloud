package com.murphy.shardingjdbc.service;/**
 * @author dongsufeng
 * @date 2019/12/5 16:29
 * @version 1.0
 */

import com.alibaba.fastjson.JSON;
import com.murphy.shardingjdbc.mapper.ConfigInfoMapper;
import com.murphy.shardingjdbc.mapper.UserMapper;
import com.murphy.shardingjdbc.mapper.UserMessageMapper;
import com.murphy.shardingjdbc.module.ConfigInfo;
import com.murphy.shardingjdbc.module.User;
import com.murphy.shardingjdbc.module.UserMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author dongsufeng
 * @date 2019/12/5 16:29
 * @version 1.0
 */
@Component
@Log4j2
public class UserService {

	@Autowired
	UserMapper userMapper;

	@Autowired
	UserMessageMapper userMessageMapper;

	@Autowired
	ConfigInfoMapper configInfoMapper;

	public String get(Long userId){
		User  user=new User();
		user.setId(userId);
		List<User> select = userMapper.select(user);
		log.info("user==========={}", JSON.toJSONString(select));
		return JSON.toJSONString(select);
	}

	public String getMessage(Long userId){
		UserMessage user=new UserMessage();
		user.setUserId(userId);
		List<UserMessage> select = userMessageMapper.select(user);
		log.info("userMessage==========={}", JSON.toJSONString(select));
		return JSON.toJSONString(select);
	}

	public String getConfig(String name){
		ConfigInfo configInfo=new ConfigInfo();
		configInfo.setName(name);
		List<ConfigInfo> select = configInfoMapper.select(configInfo);
		log.info("configInfo==========={}",JSON.toJSONString(select));
		return JSON.toJSONString(select);
	}
}
