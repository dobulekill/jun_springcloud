package com.forezp.eurekafeignclient.service;

import com.forezp.eurekafeignclient.config.FeignConfig;
import com.forezp.eurekafeignclient.config.HiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client",configuration = FeignConfig.class,
fallback = HiHystrix.class)
public interface EurekaClientFeignInf {
    @GetMapping("/hi")
    String sayHiFromClientEureka(@RequestParam(value = "name") String name);
}
