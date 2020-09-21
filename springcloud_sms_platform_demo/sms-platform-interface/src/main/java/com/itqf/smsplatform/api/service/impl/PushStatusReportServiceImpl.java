package com.itqf.smsplatform.api.service.impl;

import com.itqf.smsplatform.api.feign.CacheService;
import com.itqf.smsplatform.api.service.PushStatusReportService;
import com.itqf.smsplatform.common.constants.CacheConstants;
import com.itqf.smsplatform.common.model.Standard_Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * author:zouning
 * date:Created in 2020/4/11 23:02
 * description:
 */

@Service
public class PushStatusReportServiceImpl implements PushStatusReportService {
    @Autowired
    private CacheService cacheService;

    @Override
    public void sendReport(Standard_Report report) {
        //获取用户的回调地址
        Map map = cacheService.hmget(CacheConstants.CACHE_PREFIX_CLIENT+report.getClientID());
        if (map!=null && map.size()>0){

        }
    }
}
