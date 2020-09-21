package com.forezp.authservice.service;

import com.forezp.authservice.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userdao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails=userdao.findByUsername(username);
        System.out.println("userDetails:"+userDetails);
//        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(9);
//        ((User) userDetails).setPassword(encoder.encode(userDetails.getPassword()));
        return userDetails;
    }
}
