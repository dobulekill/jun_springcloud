package com.forezp.servicehi.service;


import com.forezp.servicehi.dao.UserDao;
import com.forezp.servicehi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(9);

    @Autowired
    private UserDao userDao;

    @Override
    public User create(User user) {
        String hash=encoder.encode(user.getPassword());
        user.setPassword(hash);
        User u=userDao.save(user);
        return u;
    }
}
