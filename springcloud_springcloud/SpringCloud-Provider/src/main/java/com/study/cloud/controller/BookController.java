package com.study.cloud.controller;

import com.study.cloud.bean.Book;
import com.study.cloud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: Leo
 * @createDate: 2020/2/10
 * @version: 1.0
 */
@RestController
@RequestMapping("/book/provide")
public class BookController
{
    @Autowired
    BookService bookService;

    @PostMapping("/")
    public boolean addBook(@RequestBody Book book)
    {
        return bookService.addBook(book);
    }

    @GetMapping("/{bookID}")
    public Book queryById(@PathVariable("bookID") Integer bookID)
    {
        return bookService.queryById(bookID);
    }

    @GetMapping("/")
    public List<Book> queryAll()
    {
        return bookService.queryAll();
    }
}
