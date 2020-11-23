package com.murphy.hystrixfeign.feign;

import com.alibaba.fastjson.JSON;
import com.murphy.feignapi.module.OrderDTO;
import com.murphy.feignapi.module.UserDTO;
import com.murphy.feignapi.service.OrderService;
import com.murphy.feignapi.service.ProductService;
import com.murphy.feignapi.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
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
public class OrderFeignService implements OrderService {

	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;

	@Override
	public OrderDTO getOrder(@RequestBody OrderDTO orderDTO) {
		log.info("feign1=={}",JSON.toJSONString(orderDTO));
		StopWatch stopWatch=new StopWatch("test");
		stopWatch.start("feign1");
		orderDTO=orderDTO==null?new OrderDTO():orderDTO;
		orderDTO.setOrderNo("order1=="+orderDTO.getOrderNo());
		UserDTO userDTO=new UserDTO();
		userDTO.setUserId("userid1");
		userDTO.setUsername("username1");
		UserDTO user = userService.getUser(userDTO);
		log.info("feign2-user=={}",JSON.toJSONString(user));
		stopWatch.stop();
		log.info(stopWatch.prettyPrint());
		orderDTO.setUserDTO(user);
		return orderDTO;
	}

	@HystrixCommand(
			groupKey = "usernameGroup",commandKey = "usernameCommand",threadPoolKey = "usernameThread",
			fallbackMethod = "getUsernameFallback",/*ignoreExceptions = Exception.class,*/
			commandProperties = {
					@HystrixProperty(name = "execution.timeout.enabled",value = "true"),
					@HystrixProperty(name = "execution.isolation.thread.interruptOnTimeout",value = "3000")
			},
			threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "30"),
					@HystrixProperty(name = "maxQueueSize", value = "101"),
					@HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
					@HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
					@HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
					@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
			}
	)
	@Override
	public String getUsername(@RequestBody OrderDTO orderDTO) {
		log.info("---------------------------=={}", JSON.toJSONString(orderDTO));
		int i=1/0;
		UserDTO userDTO=new UserDTO();
		userDTO.setUserId("userid3");
		userDTO.setUsername("username3");
		String username = productService.getUsername(userDTO);
		log.info("feign2=={}====={}",this.getClass().getSimpleName(),username);
		return username;
	}

	private String getUsernameFallback(OrderDTO orderDTO,Throwable throwable){
		log.info("fallback====={}==={}",JSON.toJSONString(orderDTO),throwable.getMessage());
		UserDTO userDTO=new UserDTO();
		userDTO.setUserId("userid4");
		userDTO.setUsername("username4");
		return userDTO.getUsername();
	}
}
