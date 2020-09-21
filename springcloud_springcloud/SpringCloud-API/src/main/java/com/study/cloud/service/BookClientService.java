package com.study.cloud.service;

import com.study.cloud.bean.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER")
public interface BookClientService
{
    @GetMapping("/book/provide/{bookID}")
    Book queryById(@PathVariable("bookID") Integer bookID);
}
