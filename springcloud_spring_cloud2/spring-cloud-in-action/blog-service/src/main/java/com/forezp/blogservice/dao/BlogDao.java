package com.forezp.blogservice.dao;

import com.forezp.blogservice.pojo.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogDao extends JpaRepository<Blog,Long> {
    List<Blog> findByUsername(String username);
}
