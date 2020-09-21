package com.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 客户端调用
 */
@FeignClient(value = "nacos-discovery-server")
public interface FeignClientService {

    @RequestMapping(value="/getMessage")
    String getMessage();

}
