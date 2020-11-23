package com.zccoder.cloud1.ch10.trace.user.repository;

import com.zccoder.cloud1.ch10.trace.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 用户资源类
 * @author Wujun
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
