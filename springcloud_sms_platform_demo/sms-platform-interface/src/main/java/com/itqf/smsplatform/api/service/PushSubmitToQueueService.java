package com.itqf.smsplatform.api.service;

import com.itqf.smsplatform.common.model.Standard_Submit;

import java.util.List;

/**
 * author:zouningsss
 * date:Created in 2020/3/16 23:12
 * description:
 */


public interface PushSubmitToQueueService {
    void sendSmsSubitToQueue(List<Standard_Submit> standard_submits);
}
