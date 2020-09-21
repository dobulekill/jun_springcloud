package com.forezp.controller;

import com.forezp.model.User;
import com.forezp.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import sun.misc.Request;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value="用户列表",notes="用户列表")
    @GetMapping("")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @ApiOperation(value="创建用户",notes="创建用户")
    @RequestMapping(value="",method = RequestMethod.POST)
    public User postUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @ApiOperation(value = "获取用户细信息",notes = "根据url的id来获取详细信息")
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }

    @ApiOperation(value="更新信息",notes="根据url的id来指定更新用户信息")
    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    public User putUser(@PathVariable Integer id,@RequestBody User user){
        User user1=new User();
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setId(id);
        return userService.updateUser(user1);
    }

    @ApiOperation(value="删除用户",notes="根据url的id来指定删除用户")
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return "success";
    }

    @ApiIgnore
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String jsonTest(){
        return "hi you!";
    }

}
