package com.itqf.smsplatform.search.utils;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Map;

/**
 * author:zouning
 * date:Created in 2020/4/11 19:07
 * description:
 */


public class SearchUtil {
    public static void buildingMapping(CreateIndexRequest createIndexRequest, String typeName) throws IOException {
        XContentBuilder xContentBuilder = JsonXContent.contentBuilder()
                .startObject()
                .startObject("properties")


                .startObject("corpName")
                .field("type", "keyword")
                .endObject()


                .startObject("createDate")
                .field("type", "date")
                //.field("format", "yyyy-MM-dd HH:mm:ss")
                .endObject()

                .startObject("fee")
                .field("type", "integer")
                .endObject()

                .startObject("ipAddr")
                .field("type", "ip")
                .endObject()


                .startObject("longCode")
                .field("type", "keyword")
                .endObject()

                .startObject("mobile")
                .field("type", "keyword")
                .endObject()

                .startObject("province")
                .field("type", "keyword")
                .endObject()

                .startObject("replyTotal")
                .field("type", "integer")
                .endObject()

                .startObject("operatorId")
                .field("type", "integer")
                .endObject()

                .startObject("smsContent")
                .field("type", "text")
                .field("analyzer", "ik_max_word")
                .endObject()

                .startObject("state")
                .field("type", "integer")
                .endObject()

                .startObject("sendDate")
                .field("type", "date")
                .field("format", "yyyy-MM-dd HH:mm:ss")
                .endObject()
                .endObject()
                .endObject();


        createIndexRequest.mapping(typeName, xContentBuilder);

    }

    /**
     * 设置 index 的分片规则
     *
     * @param createIndexRequest
     */
    public static void buildingSetting(CreateIndexRequest createIndexRequest) {
        createIndexRequest.settings(Settings.builder()//
                .put("number_of_shards", 3)// 设置主分片为 3
                .put("number_of_replicas", 2));//设置从分片为 2
    }


    public static SearchSourceBuilder builSearachSource(Map<String, Object> params) {
        String mobile = (String) params.get("mobile");
        String clietnID = (String) params.get("clientID");
        Long startTime = (Long) params.get("startTime");
        Long endTime = (Long) params.get("endTime");
        String keyword = (String) params.get("keyword");//关键字

        TermQueryBuilder mobileSearch = null;
        TermQueryBuilder clietnIDSearch = null;
        RangeQueryBuilder timeSearch = null;
        MatchQueryBuilder keywordSearch = null;

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        if (!StringUtils.isEmpty(mobile)) {
            mobileSearch = QueryBuilders.termQuery("destMobile", mobile);
        }
        if (!StringUtils.isEmpty(clietnID)) {
            clietnIDSearch = QueryBuilders.termQuery("clientID", clietnID);
        }

        if (!StringUtils.isEmpty(keyword)) {
            keywordSearch = QueryBuilders.matchQuery("messageContent", keyword);
        }

        if (!StringUtils.isEmpty(startTime) && !StringUtils.isEmpty(endTime)) {
            timeSearch = QueryBuilders.rangeQuery("sendTime").from(startTime).to(endTime);
        } else if (StringUtils.isEmpty(startTime) && !StringUtils.isEmpty(endTime)) {
            timeSearch = QueryBuilders.rangeQuery("sendTime").lte(endTime);
        } else if (!StringUtils.isEmpty(startTime) && StringUtils.isEmpty(endTime)) {
            timeSearch = QueryBuilders.rangeQuery("sendTime").gte(startTime);
        }
        //用于包装查询条件的 boolean 查询
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        if (mobileSearch != null) {
            boolQueryBuilder.must(mobileSearch);
        }

        if (clietnIDSearch != null) {
            boolQueryBuilder.must(clietnIDSearch);
        }
        if (timeSearch != null) {
            boolQueryBuilder.must(timeSearch);
        }
        if (keywordSearch != null) {
            boolQueryBuilder.must(keywordSearch);
        }

        searchSourceBuilder.query(boolQueryBuilder);

        return searchSourceBuilder;
    }
}
