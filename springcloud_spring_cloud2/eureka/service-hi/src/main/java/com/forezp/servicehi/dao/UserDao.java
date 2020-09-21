package com.forezp.servicehi.dao;

import com.forezp.servicehi.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {

}
