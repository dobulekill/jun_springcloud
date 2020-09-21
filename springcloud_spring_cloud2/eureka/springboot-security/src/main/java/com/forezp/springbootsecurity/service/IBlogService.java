package com.forezp.springbootsecurity.service;

import com.forezp.springbootsecurity.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getBlogs();
    void deleteBlog(int id);
}
