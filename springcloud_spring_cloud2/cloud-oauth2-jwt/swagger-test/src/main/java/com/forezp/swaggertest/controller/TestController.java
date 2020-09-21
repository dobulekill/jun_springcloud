package com.forezp.swaggertest.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value = "test hi 服务",notes = "test hi")
    @GetMapping("/hi")
    public String hi(){
        return "hi test";
    }
}
