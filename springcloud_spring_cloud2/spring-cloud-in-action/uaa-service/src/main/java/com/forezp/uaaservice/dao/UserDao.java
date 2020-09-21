package com.forezp.uaaservice.dao;

import com.forezp.uaaservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
