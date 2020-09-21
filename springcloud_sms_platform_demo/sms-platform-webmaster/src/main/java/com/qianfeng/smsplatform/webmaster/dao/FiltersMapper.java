package com.qianfeng.smsplatform.webmaster.dao;


import com.qianfeng.smsplatform.webmaster.pojo.TFilters;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * author:zouningsss
 * date:Created in 2020/3/17 17:31
 * description:
 */

public interface FiltersMapper {
    @Update("update t_filters set filters=#{filters} where filterorder =#{filterOrder}")
    int updateFilters(@Param("filterOrder") String filterOrder, @Param("filters") String filters) throws Exception;


    void addFilters(TFilters filter) throws Exception;
}
