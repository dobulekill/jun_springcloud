package com.forezp.springbootsecurity.service.impl;

import com.forezp.springbootsecurity.entity.Blog;
import com.forezp.springbootsecurity.service.IBlogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    private List<Blog> list=new ArrayList<>();

    public BlogService() {
        list.add(new Blog(1,"spring in action","good!"));
        list.add(new Blog(2,"spring boot in action","nice!"));
    }

    @Override
    public List<Blog> getBlogs() {
        return list;
    }

    @Override
    public void deleteBlog(int id) {
        Iterator iter=list.iterator();
        while (iter.hasNext()){
            Blog blog= (Blog) iter.next();
            if(blog.getId()==id){
                iter.remove();
            }
        }
    }
}
