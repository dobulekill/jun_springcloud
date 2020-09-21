package com.forezp.blogservice.controller;

import com.forezp.blogservice.dto.BlogDetailDTO;
import com.forezp.blogservice.service.BlogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @ApiOperation(value="获取博文的详细信息",notes = "获取博文的详细信息")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/{id}/detail")
    public ResponseEntity<BlogDetailDTO> getBlogDetail(@PathVariable Long id){
        return new ResponseEntity<>(blogService.findBlogById(id), HttpStatus.OK);
    }
}
