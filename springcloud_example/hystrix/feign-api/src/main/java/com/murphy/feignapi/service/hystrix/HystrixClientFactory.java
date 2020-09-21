package com.murphy.feignapi.service.hystrix;

import com.murphy.feignapi.module.UserDTO;
import com.murphy.feignapi.service.UserService;
import feign.hystrix.FallbackFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 *
 * @author dongsufeng
 * @date 2019/11/27 14:23
 * @version 1.0
 */
@Component
@Log4j2
public class HystrixClientFactory implements FallbackFactory<UserService> {
	@Override
	public UserService create(Throwable throwable) {
		log.error("{}{}",throwable.getMessage(),"==============");
		return (userDTO)-> {
			log.info("系统异常=={}",userDTO==null?"userDTO is null":userDTO.toString());
			UserDTO dto=new UserDTO();
			dto.setUsername("error-username");
			dto.setUserId("error-userid");
			return dto;
		};
	}
}
