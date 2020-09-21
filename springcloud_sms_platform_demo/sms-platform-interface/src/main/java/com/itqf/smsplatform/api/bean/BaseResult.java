package com.itqf.smsplatform.api.bean;

/**
 * author:zouningsss
 * date:Created in 2020/3/16 22:39
 * description:
 */


public class BaseResult {
    private String code;
    private String msg;

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
