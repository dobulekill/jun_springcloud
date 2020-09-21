package com.forezp.userservice.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class UserLoginExceptionHandler {
    @ExceptionHandler(UserLoginException.class)
    public ResponseEntity<String> handleException(Exception e){
        return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
    }
}
