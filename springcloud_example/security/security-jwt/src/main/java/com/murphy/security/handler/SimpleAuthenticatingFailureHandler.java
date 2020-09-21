package com.murphy.security.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.lang.Assert;
import org.springframework.util.StringUtils;

/**
 * 登陆失败处理
 * @author dongsufeng
 * @date 2019/12/02 15:17
 * @version 1.0
 */
@Component
@Log4j2
public class SimpleAuthenticatingFailureHandler implements AuthenticationFailureHandler, InitializingBean, MessageSourceAware {

    private static String AUTH_FAILURE_MESSAGES = "k.security.authenticate.failure";

    private MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    private static String buildExceptionMessageKey(AuthenticationException e) {
        return AUTH_FAILURE_MESSAGES + "." + AuthenticationException.class.getSimpleName();
    }

	/**
	 * 登陆失败处理，可自定义对象返回
	 * @throws IOException
	 * @throws ServletException
	 */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        String exceptionMessage=null;
        if (e != null && (e instanceof AuthenticationServiceException || e instanceof BadCredentialsException)) {
            log.info(e.getMessage());
            exceptionMessage="用户名或密码错误";
        } else{
            String defaultFailureMessage = messages.getMessage(AUTH_FAILURE_MESSAGES, "Authentication failed");
            exceptionMessage = messages.getMessage(buildExceptionMessageKey(e), defaultFailureMessage);
            response.sendError(HttpServletResponse.SC_FORBIDDEN, exceptionMessage);
        }
        Map<String,Object> map=new HashMap<>(3);
        map.put("code","401");
        map.put("message",exceptionMessage);
        map.put("data",Boolean.FALSE);
        response.setCharacterEncoding("UTF-8");
        JSONObject.writeJSONString(response.getWriter(),map);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(messages, "The message accessor can't be null!");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messages = new MessageSourceAccessor(messageSource);
    }
}

