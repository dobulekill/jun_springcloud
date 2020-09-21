package com.forezp.springbootsecurity.controller;

import com.forezp.springbootsecurity.entity.Blog;
import com.forezp.springbootsecurity.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping
    public ModelAndView list(Model model){
        List<Blog> list=blogService.getBlogs();
        model.addAttribute("blogsList",list);
        return new ModelAndView("blogs/list","blogModel",model);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{id}/deletion")
    public ModelAndView delete(@PathVariable("id") String id,Model model){
        blogService.deleteBlog(Integer.parseInt(id));
        model.addAttribute("blogsList",blogService.getBlogs());
        return new ModelAndView("blogs/list","blogModel",model);
    }
}
