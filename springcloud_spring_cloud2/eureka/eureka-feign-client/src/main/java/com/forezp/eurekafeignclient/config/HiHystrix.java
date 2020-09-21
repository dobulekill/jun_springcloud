package com.forezp.eurekafeignclient.config;

import com.forezp.eurekafeignclient.service.EurekaClientFeignInf;
import org.springframework.stereotype.Component;

@Component
public class HiHystrix implements EurekaClientFeignInf {
    @Override
    public String sayHiFromClientEureka(String name) {
        return "hi,"+name+",sorry,error! feign";
    }
}
