package com.murphy.security.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.murphy.security.jwt.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 登陆成功后处理
 * @author Wujun
 * @date 2019/12/02 15:01
 * @version 1.0
 */
@Component
public class SimpleAuthenticatingSuccessHandler implements AuthenticationSuccessHandler {

    private static ObjectMapper globalObjectMapper = new ObjectMapper();

    @Autowired
    private JwtService jwtService;

    static {
        globalObjectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private Logger logger = LoggerFactory.getLogger(SimpleAuthenticatingSuccessHandler.class);

    private static void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

	/**
	 * 登陆成功返回token给用户
	 * @param authentication
	 * @throws IOException
	 * @throws ServletException
	 */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Map<String, Object> result = new HashMap<>();
        logger.info("登录成功返回对象==={}",JSONObject.toJSONString(authentication.getPrincipal()));
        result.put("token", jwtService.generateToken(authentication));
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        globalObjectMapper.writeValue(response.getWriter(), result);
        clearAuthenticationAttributes(request);
    }

}

