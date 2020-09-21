package com.study.cloud.service;

import com.study.cloud.bean.Book;

import java.util.List;

public interface BookService
{
    boolean addBook(Book book);

    Book queryById(Integer bookID);

    List<Book> queryAll();
}
