package com.forezp.userservice.service;

import com.forezp.userservice.client.AuthServiceClient;
import com.forezp.userservice.common.BPwdEncoderUtils;
import com.forezp.userservice.common.CommonException;
import com.forezp.userservice.common.ErrorCode;
import com.forezp.userservice.common.UserLoginException;
import com.forezp.userservice.dao.UserDao;
import com.forezp.userservice.dto.LoginDTO;
import com.forezp.userservice.dto.RespDTO;
import com.forezp.userservice.dto.UserLoginDTO;
import com.forezp.userservice.pojo.JWT;
import com.forezp.userservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    AuthServiceClient authServiceClient;

    @Value("${jwt.authorization}")
    String jwtAuthorization;

    @Value("${jwt.grant-type}")
    String jwtGrantType;

    public RespDTO login(String username,String password){
        User user=userDao.findByUsername(username);
        if(null==user){
            throw new CommonException(ErrorCode.USER_NOT_FOUND);
        }
        if(!BPwdEncoderUtils.match(password,user.getPassword())){
            throw new CommonException(ErrorCode.USER_PASSWORD_ERROR);
        }
        JWT jwt=authServiceClient.getToken("Basic dWFhLXNlcnZpY2U6MTIzNDU2",
                "password",username,password);
        //获得用户菜单
        if(null==jwt){
            throw new CommonException(ErrorCode.GET_TOKEN_FAIL);
        }
        LoginDTO loginDTO=new LoginDTO();
        loginDTO.setUser(user);
        loginDTO.setToken(jwt.getAccess_token());
        return new RespDTO(loginDTO,HttpStatus.OK.value());
    }

    public User insertUser(String username,String password){
        User user=new User();
        user.setUsername(username);
        user.setPassword(BPwdEncoderUtils.encode(password));
        return userDao.save(user);
    }
    public UserLoginDTO login_seperate(String username,String password){
        User user=userDao.findByUsername(username);
        if(null==user){
            throw new UserLoginException("error username");
        }
        if(!BPwdEncoderUtils.match(password,user.getPassword())){
            throw new UserLoginException("error password");
        }
        JWT jwt=authServiceClient.getToken(jwtAuthorization,jwtGrantType,
                username,password);
//        JWT jwt=authServiceClient.getToken("Basic dXNlci1zZXJ2aWNlOjEyMzQ1Ng==",
//                "password",username,password);
        if(jwt==null){
            throw new UserLoginException("error internal");
        }
        UserLoginDTO userLoginDTO=new UserLoginDTO();
        userLoginDTO.setJwt(jwt);
        userLoginDTO.setUser(user);
        return userLoginDTO;
    }

    public List<User> findAll(){
        return userDao.findAll();
    }
}
