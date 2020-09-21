package com.forezp.blogservice.common;

public class CommonException extends RuntimeException {
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public CommonException() {
    }

    public CommonException(String message) {
        super(message);
    }
}
