package com.study.cloud.controller;

import com.study.cloud.bean.Book;
import com.study.cloud.service.BookClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @description: 这里我是消费者，我在消费的时候需要自己有service层吗？我觉得显然是否定，那么问题来了，如果
 * controller没有service他该如何去调用service呢？
 * 通过RestTemplate
 * @author: Leo
 * @createDate: 2020/2/10
 * @version: 1.0
 */
@RestController
public class BookConSumController
{
    @Autowired
    BookClientService bookClientService = null;

    @RequestMapping("/book/consumer/get/{bookID}")
    public Book getBookById(@PathVariable("bookID") Integer bookID)
    {
        return this.bookClientService.queryById(bookID);
    }
}
