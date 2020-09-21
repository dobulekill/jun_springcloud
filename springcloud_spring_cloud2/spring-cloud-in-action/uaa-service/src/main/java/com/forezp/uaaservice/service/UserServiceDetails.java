package com.forezp.uaaservice.service;

import com.forezp.uaaservice.dao.UserDao;
import com.forezp.uaaservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDetails implements UserDetailsService {
    Logger logger=LoggerFactory.getLogger(UserServiceDetails.class);

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userDao.findByUsername(username);
        logger.info("UserServiceDetail loadUserByUsername:"+user);
        return user;
    }
}
