package com.forezp.userservice.service;

import com.forezp.userservice.dao.UserDao;
import com.forezp.userservice.exception.UserLoginException;
import com.forezp.userservice.pojo.JWT;
import com.forezp.userservice.pojo.User;
import com.forezp.userservice.pojo.UserLoginDTO;
import com.forezp.userservice.utils.BPwdEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDetail {

    @Autowired
    UserDao userDao;

    public User insertUser(String username,String password){
        User user=new User();
        user.setUsername(username);
        user.setPassword(BPwdEncoderUtil.BCryptPassword(password));
        return userDao.save(user);
    }

    @Autowired
    AuthServiceClient client;

    public UserLoginDTO login(String username,String password){
        User user=userDao.findByUsername(username);
        if(null==user){
            throw new UserLoginException("error username");
        }
        if(!BPwdEncoderUtil.matches(password,user.getPassword())){
            throw new UserLoginException("error password");
        }
        JWT jwt=client.getToken("Basic dXNlci1zZXJ2aWNlOjEyMzQ1Ng==",
                "password",username,password);
        if(jwt==null){
            throw new UserLoginException("error internal");
        }
        UserLoginDTO userLoginDTO=new UserLoginDTO();
        userLoginDTO.setJwt(jwt);
        userLoginDTO.setUser(user);
        return userLoginDTO;
    }
}
