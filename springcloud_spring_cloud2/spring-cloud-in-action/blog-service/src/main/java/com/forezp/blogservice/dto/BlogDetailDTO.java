package com.forezp.blogservice.dto;

import com.forezp.blogservice.pojo.Blog;
import com.forezp.blogservice.pojo.User;

public class BlogDetailDTO {
    private Blog blog;
    private User user;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
