package com.example.demo.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.murphy.security.service.UserExtendService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dongsufeng
 * @version 4.0
 * @date 2019/12/2 4:30 PM
 */
@Component
@Log4j2
public class UserDetailsService implements UserExtendService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("18888888888".equals(username)) {
            User user = new User("18888888888", PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456"), "userid1111101111");
            user.setMobile("13333333333");
            return user;
        }else {
            return null;
        }
    }
    @Override
    public boolean validate(HttpServletRequest request){
        log.info("-----------------------{}=",request.getRequestURI());
        return true;
    };

}
