package com.forezp.userservice.common;

public class UserLoginException extends RuntimeException {
    public UserLoginException(String message){
        super(message);
    }
}
