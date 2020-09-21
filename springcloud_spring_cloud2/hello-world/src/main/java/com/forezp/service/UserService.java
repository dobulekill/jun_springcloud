package com.forezp.service;

import com.forezp.dao.UserDao;
import com.forezp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findUserByUsername(String username){
        return userDao.findByUsername(username);
    }

    public List<User> findAll(){
        return userDao.findAll();
    }
    public User saveUser(User user){
        return userDao.save(user);
    }
    public User findUserById(int id){
        return userDao.findOne(id);
    }
    public User updateUser(User user){
        return userDao.saveAndFlush(user);
    }
    public void deleteUser(int id){
        userDao.delete(id);
    }
}
