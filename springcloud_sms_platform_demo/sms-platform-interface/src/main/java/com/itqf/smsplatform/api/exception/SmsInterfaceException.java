package com.itqf.smsplatform.api.exception;


/**
 * Created by jackiechan on 2020-02-26 10:58
 *
 * @author Wujun
 */
public class SmsInterfaceException extends RuntimeException {

    private String code;

    private String msg;


    public SmsInterfaceException() {
    }

    public SmsInterfaceException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
