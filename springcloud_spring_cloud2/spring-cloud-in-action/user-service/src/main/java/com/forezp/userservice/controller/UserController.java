package com.forezp.userservice.controller;

import com.forezp.userservice.dto.UserLoginDTO;
import com.forezp.userservice.pojo.User;
import com.forezp.userservice.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "登录操作",notes = "登录操作")
    @GetMapping("/login")
    public UserLoginDTO login(@RequestParam String username,
                              @RequestParam String password){
//        return userService.login(username,password);
        return userService.login_seperate(username,password);
    }
    @ApiOperation(value="注册用户",notes = "注册用户")
    @PostMapping("/register")
    public User postUser(@RequestParam String username,@RequestParam String password){
        return userService.insertUser(username,password);
    }

    @ApiOperation(value="用户列表",notes = "用户列表")
    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
}
