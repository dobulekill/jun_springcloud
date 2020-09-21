package com.itqf.smsplatform.api.service;

/**
 * author:zouningsss
 * date:Created in 2020/3/16 14:21
 * description:
 */


public interface SmsCheckService {
    void checkSms(String clientId, String pwd, String srcID, String ip, String Content, String mobile) throws Exception;
}
