package com.murphy.security.exception;

/**
 * @author Wujun
 * @version 4.0
 * @date 2019/12/2 5:33 PM
 */
public class AuthenticationException extends RuntimeException {
    private String code;

    private String message;

    public AuthenticationException(){
        super();
    }
    public AuthenticationException(String code,String message){
        super(message);
        this.code=code;
        this.message=message;
    }
    public AuthenticationException(String message){
        super(message);
        this.message=message;
    }
}
