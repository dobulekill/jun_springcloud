package net.chengp.consumer.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @FeignClient(value="provider") 指定服务名称
 */
@FeignClient(value="provider", fallback=ProviderServiceFallback.class/**针对接口设置错误回调，如果和@HystrixCommand同时存在则先执行这里*/)
public interface ProviderService {
	
	@RequestMapping("/providerResult")//指定服务controller地址
	public String providerReuslt(/**如果是表单格式的参数可用@RequestParam("id")传递，若是json格式的传参则使用@RequestBody传递*/);

}
