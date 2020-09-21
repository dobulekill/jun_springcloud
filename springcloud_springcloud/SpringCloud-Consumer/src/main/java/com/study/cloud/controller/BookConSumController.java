package com.study.cloud.controller;

import com.study.cloud.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    RestTemplate restTemplate;//提供多种便捷访问远程http服务的方法，是一个简单的restful服务模板

    //private static final String REST_URL_PREFIX = "http://localhost:8001/book/provide";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER/book/provide";
    //public <T> T getForObject(String url, Class<T> responseType, Object... uriVariables)
    // throws RestClientException
    @RequestMapping("/book/consumer/post")
    public boolean addBook(Book book)
    {
        return restTemplate.postForObject(REST_URL_PREFIX + "/", book, Boolean.class);
    }

    @RequestMapping("/book/consumer/get/{bookID}")
    public Book getBookById(@PathVariable("bookID") Integer bookID)
    {
        return restTemplate.getForObject(REST_URL_PREFIX + "/" + bookID, Book.class);
    }

    @RequestMapping("/book/consumer/get")
    public List<Book> getAllBook()
    {
        //System.out.println("开始提供！");
        return restTemplate.getForObject(REST_URL_PREFIX + "/", List.class);
    }

}
