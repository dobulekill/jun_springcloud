package com.study.cloud.service;

import com.study.cloud.bean.Book;
import com.study.cloud.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Leo
 * @createDate: 2020/2/10
 * @version: 1.0
 */
@Service
public class BookServiceImp implements BookService
{
    @Autowired
    BookMapper bookMapper;

    public boolean addBook(Book book)
    {
        return bookMapper.addBook(book);
    }

    public Book queryById(Integer bookID)
    {
        return bookMapper.queryById(bookID);
    }

    public List<Book> queryAll()
    {
        return bookMapper.queryAll();
    }
}
