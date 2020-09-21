package com.forezp.blogservice.dto;

public class RespDTO {
    private int code;
    private String error;
    private Object response;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
    public RespDTO() {
    }

    public RespDTO(Object response, int code) {
        this.response = response;
        this.code=code;
    }
}
