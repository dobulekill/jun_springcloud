package com.zccoder.cloud1.ch10.trace.elk.repository;

import com.zccoder.cloud1.ch10.trace.elk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 用户资源类
 * @author Wujun
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
