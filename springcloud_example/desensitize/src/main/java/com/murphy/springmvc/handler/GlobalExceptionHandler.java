package com.murphy.springmvc.handler;

import com.murphy.springmvc.exception.BusinessExcetpion;
import com.murphy.springmvc.exception.LoginException;
import com.murphy.springmvc.model.ResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author dongsufeng
 * @date 2019/12/18 16:50
 * @version 1.0
 */
@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {
	@ExceptionHandler(value = BusinessExcetpion.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseDTO<Boolean> verifyErrorHandler(HttpServletRequest request, Exception e){
		log.info("BusinessExcetpion={}",e.getMessage(),e);
		return new ResponseDTO<Boolean>().build("100001",e.getMessage(),Boolean.TRUE);
	}
	@ExceptionHandler(value = LoginException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseDTO<Boolean> verifyLoginErrorHandler(HttpServletRequest request, Exception e){
		log.info("LoginException={}",e.getMessage(),e);
		return new ResponseDTO<Boolean>().build("200001",e.getMessage(),Boolean.TRUE);
	}
}
