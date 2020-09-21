package com.qianfeng.smsplatform.webmaster.service;


import com.qianfeng.smsplatform.webmaster.pojo.TFilters;

/**
 * author:zouningsss
 * date:Created in 2020/3/17 17:33
 * description:
 */

public interface FiltersService {

    int updateFilters(String filterOrder, String filters) throws Exception;

    void addFilters(TFilters filter) throws Exception;
}
