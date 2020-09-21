package com.itqf.smsplatform.search.service;

import com.itqf.smsplatform.common.model.Standard_Report;

public interface SearchService {

    void creatindex() throws Exception;

    void deleteIndex(String index) throws Exception;

    void add(String json) throws Exception;

    boolean update(Standard_Report report) throws Exception;

    boolean existsIndex(String index) throws Exception;
}
