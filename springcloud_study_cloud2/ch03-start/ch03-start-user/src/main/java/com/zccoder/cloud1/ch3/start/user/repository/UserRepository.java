package com.zccoder.cloud1.ch3.start.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zccoder.cloud1.ch3.start.user.entity.User;

/**
 * 用户资源类
 * @author Wujun
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
