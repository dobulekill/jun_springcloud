package com.itqf.smsplatform.strategy.service;

import com.itqf.smsplatform.common.model.Standard_Submit;

/**
 * author:zouningsss
 * date:Created in 2020/3/17 17:58
 * description:
 */


public interface QueueService {

    /**
     * 发送统计数据到 es
     *
     * @param standard_submit
     * @param errorCode
     */
    void sendSubmitToMQ(Standard_Submit standard_submit, String errorCode);

    /**
     * 发送状态报告到接口模块
     *
     * @param standard_submit
     * @param errorCode
     */
    void sendSmsReport(Standard_Submit standard_submit, String errorCode);

}
