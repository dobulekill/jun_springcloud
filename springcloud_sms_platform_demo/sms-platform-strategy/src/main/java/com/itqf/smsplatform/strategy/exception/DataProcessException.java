package com.itqf.smsplatform.strategy.exception;

/**
 * author:zouningsss
 * date:Created in 2020/3/17 15:27
 * description:
 */


public class DataProcessException extends RuntimeException {
    private String code;

    private String msg;


    public DataProcessException() {
    }

    public DataProcessException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
