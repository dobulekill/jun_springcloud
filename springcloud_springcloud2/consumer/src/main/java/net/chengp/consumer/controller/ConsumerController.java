package net.chengp.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import net.chengp.consumer.rpc.ProviderService;

@RestController
public class ConsumerController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ProviderService providerService;
	
	@RequestMapping("/testRibbon")
	public String testRibbon() {
		String result = restTemplate.getForObject("http://provider/providerResult", String.class);
		return "testRibbon result="+result;
	}
	
	
	@RequestMapping("/testFeign")
	public String testFeign() {
		String result = providerService.providerReuslt();
		return "testFeign result="+result;
	}
	
	@RequestMapping("/testHystrix")
	@HystrixCommand(fallbackMethod="hystrixFallbackMethod",commandKey="provider")
	public String testHystrix() {
		String result = providerService.providerReuslt();
		return "testHystrix result="+result;
	}
	
	
	public String hystrixFallbackMethod() {
		return "hystrixFallbackMethod invoker.";
	}
	
}
