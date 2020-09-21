package com.example.demo.entity;

import com.murphy.security.dto.UserDTO;

import lombok.Data;

/**
 * 用户信息
 * @author dongsufeng
 * @date 2019/9/17 19:34
 * @version 1.0
 */
@Data
public class User extends UserDTO {


    private String mobile;
    public User(String username, String password,String userId) {
        super.setUsername(username);
        setUserId(userId);
        setPassword(password);
    }
    public User(){}


}
