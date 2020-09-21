package com.wujunshen.dao;

import com.wujunshen.entity.Book;
import com.wujunshen.entity.BookCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table simple_book
     *
     * @mbggenerated Mon Nov 21 14:11:40 CST 2016
     */
    int countByExample(BookCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table simple_book
     *
     * @mbggenerated Mon Nov 21 14:11:40 CST 2016
     */
    int deleteByExample(BookCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table simple_book
     *
     * @mbggenerated Mon Nov 21 14:11:40 CST 2016
     */
    int deleteByPrimaryKey(Integer bookId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table simple_book
     *
     * @mbggenerated Mon Nov 21 14:11:40 CST 2016
     */
    int insert(Book record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table simple_book
     *
     * @mbggenerated Mon Nov 21 14:11:40 CST 2016
     */
    int insertSelective(Book record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table simple_book
     *
     * @mbggenerated Mon Nov 21 14:11:40 CST 2016
     */
    List<Book> selectByExample(BookCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table simple_book
     *
     * @mbggenerated Mon Nov 21 14:11:40 CST 2016
     */
    Book selectByPrimaryKey(Integer bookId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table simple_book
     *
     * @mbggenerated Mon Nov 21 14:11:40 CST 2016
     */
    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table simple_book
     *
     * @mbggenerated Mon Nov 21 14:11:40 CST 2016
     */
    int updateByExample(@Param("record") Book record, @Param("example") BookCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table simple_book
     *
     * @mbggenerated Mon Nov 21 14:11:40 CST 2016
     */
    int updateByPrimaryKeySelective(Book record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table simple_book
     *
     * @mbggenerated Mon Nov 21 14:11:40 CST 2016
     */
    int updateByPrimaryKey(Book record);
}