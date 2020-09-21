package com.forezp.servicehi.controller;

import com.forezp.servicehi.pojo.User;
import com.forezp.servicehi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registry",method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userService.create(user);
    }
}
