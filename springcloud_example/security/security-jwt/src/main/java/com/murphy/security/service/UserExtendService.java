package com.murphy.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;

/**
 * 非用户名密码验证
 * @author dongsufeng
 * @version 4.0
 * @date 2019/12/3 3:48 PM
 */
public interface UserExtendService extends UserDetailsService{
    /**
     * 业务校验
     * @param request
     * @return
     */
    default boolean validate(HttpServletRequest request){
        return true;
    };
}
