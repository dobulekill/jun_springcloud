package com.forezp.userservice.controller;

import com.forezp.userservice.pojo.User;
import com.forezp.userservice.pojo.UserLoginDTO;
import com.forezp.userservice.service.UserServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceDetail userServiceDetail;

    @RequestMapping("/register")
    public User postUser(@RequestParam("username") String username,
                         @RequestParam("password") String password){
        return userServiceDetail.insertUser(username,password);
    }

    @RequestMapping("/login")
    public UserLoginDTO login(@RequestParam("username") String username,
                              @RequestParam("password") String password){
        return userServiceDetail.login(username,password);
    }
}
