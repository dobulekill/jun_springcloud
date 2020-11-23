package com.murphy.feignapi.service;/**
 * @author Wujun
 * @date 2019/11/27 11:15
 * @version 1.0
 */

import com.murphy.feignapi.module.OrderDTO;
import com.murphy.feignapi.module.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Wujun
 * @date 2019/11/27 11:15
 * @version 1.0
 */
@FeignClient(name = "hystrix-feign1",primary = false)
public interface OrderService {
	@PostMapping("/feign1/order/get")
	OrderDTO getOrder(OrderDTO orderDTO);

	@PostMapping("/feign1/user-id")
	String getUsername(OrderDTO orderDTO);
}
