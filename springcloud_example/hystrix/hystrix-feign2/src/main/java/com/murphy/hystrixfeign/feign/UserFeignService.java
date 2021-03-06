package com.murphy.hystrixfeign.feign;

import com.alibaba.fastjson.JSON;
import com.murphy.feignapi.module.UserDTO;
import com.murphy.feignapi.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Wujun
 * @date 2019/11/27 11:06
 * @version 1.0
 */
@RestController
@Log4j2
public class UserFeignService implements UserService {

	@Override
	public UserDTO getUser(@RequestBody UserDTO userDTO) {
		log.info("====={}", JSON.toJSONString(userDTO));
		userDTO=userDTO==null ? new UserDTO():userDTO;
		userDTO.setUserId("userid2");
		userDTO.setUsername("username2");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return userDTO;
	}

}
