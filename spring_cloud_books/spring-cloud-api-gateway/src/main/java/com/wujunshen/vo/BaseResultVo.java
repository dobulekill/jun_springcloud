package com.wujunshen.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * User:Administrator(吴峻申)
 * Date:2015-11-30
 * Time:11:12
 * Mail:frank_wjs@hotmail.com
 */
public class BaseResultVo implements Serializable {
    private static final long serialVersionUID = -7978635757653362784L;
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseResultVo.class);
    private int code;
    private String message;
    // 返回数据
    private Object data;

    public BaseResultVo() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResultVo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}