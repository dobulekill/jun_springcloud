package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.murphy.security.dto.UserDTO;

import lombok.extern.log4j.Log4j2;

/**
 * @author Wujun
 * @version 4.0
 * @date 2019/12/2 4:19 PM
 */
@RestController
@Log4j2
public class SecurityJwtController {

    @PostMapping("/jwt")
    public User get(@RequestAttribute String userInfoDTO){
        log.info("=================userInfoDTO={}",userInfoDTO);
        User user= JSONObject.parseObject(userInfoDTO,User.class);

        return user;
    }
}
