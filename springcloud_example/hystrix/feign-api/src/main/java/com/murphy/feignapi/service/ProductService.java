package com.murphy.feignapi.service;

import com.murphy.feignapi.module.UserDTO;
import com.murphy.feignapi.service.hystrix.HystrixClientFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author dongsufeng
 * @date 2019/11/27 10:55
 * @version 1.0
 */
@FeignClient(name = "hystrix-feign2",primary = false)
public interface ProductService {

	@PostMapping("/feign2/user-id")
	String getUsername(UserDTO userDTO);
}
