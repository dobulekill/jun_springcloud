package com.itqf.smsplatform.search.service.impl;

import com.itqf.smsplatform.common.model.Standard_Report;
import com.itqf.smsplatform.search.service.SearchService;
import com.itqf.smsplatform.search.utils.SearchUtil;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {

    @Value("${spring.data.elasticsearch.index}")
    private String index;

    @Value("${spring.data.elasticsearch.type}")
    private String type;

    @Autowired
    private RestHighLevelClient client;

    @Override
    public void creatindex() throws Exception {
        if (!existsIndex(index)){
            //不存在便创建
            CreateIndexRequest createIndexRequest = new CreateIndexRequest();
            SearchUtil.buildingSetting(createIndexRequest);
            SearchUtil.buildingMapping(createIndexRequest,type);
            CreateIndexResponse response = client.indices().create(createIndexRequest,RequestOptions.DEFAULT);
        }else {

        }
    }

    @Override
    public void deleteIndex(String index) throws Exception {

    }

    @Override
    public void add(String json) throws Exception {
        IndexRequest indexRequest = new IndexRequest(index,type);
        indexRequest.source(json, XContentType.JSON);
        IndexResponse index = client.index(indexRequest, RequestOptions.DEFAULT);

    }

    @Override
    public boolean update(Standard_Report report) throws Exception {
        return false;
    }

    @Override
    public boolean existsIndex(String index) throws Exception {
        GetRequest getRequest = new GetRequest(index);

        return client.exists(getRequest, RequestOptions.DEFAULT);
    }


}
