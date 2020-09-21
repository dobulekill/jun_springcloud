package com.study.cloud.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @description:
 * 1.实体类必须实现序列化
 * @author: Leo
 * @createDate: 2020/2/8
 * @version: 1.0
 */
@Data
//@Accessors(chain = true)//开启链式写法
public class Book implements Serializable
{
    private Integer bookID;
    private String bookName;
    private Integer bookCounts;
    private String detail;
    private String db_source;

    public Book()
    {
    }

    public Book(String bookName, Integer bookCounts, String detail, String db_source)
    {
        this.bookName = bookName;
        this.bookCounts = bookCounts;
        this.detail = detail;
        this.db_source = db_source;
    }
}
