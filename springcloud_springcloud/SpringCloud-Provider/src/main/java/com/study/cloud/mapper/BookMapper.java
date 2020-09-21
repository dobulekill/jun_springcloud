package com.study.cloud.mapper;

import com.study.cloud.bean.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: Leo
 * @createDate: 2020/2/10
 * @version: 1.0
 */
@Mapper
@Repository
public interface BookMapper
{
    boolean addBook(Book book);
    Book queryById(Integer bookID);
    List<Book> queryAll();
}
