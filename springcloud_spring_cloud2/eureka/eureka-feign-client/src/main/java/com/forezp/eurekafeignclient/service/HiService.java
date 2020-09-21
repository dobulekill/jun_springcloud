package com.forezp.eurekafeignclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiService {

    @Autowired
    EurekaClientFeignInf eurekaClientFeignInf;

    public String sayHi(String name){
        return eurekaClientFeignInf.sayHiFromClientEureka(name);
    }
}
