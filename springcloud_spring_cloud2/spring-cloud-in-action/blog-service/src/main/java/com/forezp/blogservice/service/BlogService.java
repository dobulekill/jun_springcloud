package com.forezp.blogservice.service;

import com.forezp.blogservice.client.UserServiceClient;
import com.forezp.blogservice.common.CommonException;
import com.forezp.blogservice.common.ErrorCode;
import com.forezp.blogservice.dao.BlogDao;
import com.forezp.blogservice.dto.BlogDetailDTO;
import com.forezp.blogservice.pojo.Blog;
import com.forezp.blogservice.pojo.User;
import com.forezp.blogservice.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    BlogDao blogDao;

    @Autowired
    UserServiceClient userServiceClient;

    public BlogDetailDTO findBlogById(Long id){
        Blog blog=blogDao.findOne(id);
        if(null==blog){
            throw new CommonException(ErrorCode.BLOG_IS_NOT_EXIST);
        }
        ResponseEntity<User> responseEntity=userServiceClient.getUser(
                UserUtils.getCurrentToken(),blog.getUsername());
        if(responseEntity==null){
            throw new CommonException(ErrorCode.RPC_ERROR);
        }
        BlogDetailDTO blogDetailDTO=new BlogDetailDTO();
        blogDetailDTO.setBlog(blog);
        blogDetailDTO.setUser(responseEntity.getBody());
        return blogDetailDTO;
    }
}
