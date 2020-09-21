package com.itqf.smsplatform.api.service;

import com.itqf.smsplatform.common.model.Standard_Report;

/**
 * author:zouning
 * date:Created in 2020/4/11 23:01
 * description:
 */


public interface PushStatusReportService {
    void sendReport(Standard_Report report);
}
