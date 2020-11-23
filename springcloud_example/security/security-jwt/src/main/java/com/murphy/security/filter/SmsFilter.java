package com.murphy.security.filter;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.murphy.security.enums.MatcherRule;
import com.murphy.security.filter.matcher.RequestMatcher;
import com.murphy.security.properties.LoginExtendProperty;
import com.murphy.security.token.SmsAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StreamUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * 覆盖UsernamePasswordAuthenticationFilter 可自定义用户名密码字段，字段取值从body取
 * @see UsernamePasswordAuthenticationFilter
 * @author Wujun
 * @date 2019/12/02 14:58
 * @version 1.0
 */
public class SmsFilter extends AbstractAuthenticationProcessingFilter {

	@Autowired
	LoginExtendProperty loginExtendProperty;


	/**
	 * 重新定义登陆地址
	 * @param authenticationManager
	 */
    public SmsFilter(AuthenticationManager authenticationManager, String loginUrl) {
        super(new AntPathRequestMatcher(loginUrl, HttpMethod.POST.name()));
        setAuthenticationManager(authenticationManager);
		setRequiresAuthenticationRequestMatcher(new RequestMatcher(MatcherRule.SMS.getRuleName()));
    }

	/**
	 * 从body取用户名密码
	 * @return
	 * @throws AuthenticationServiceException
	 * @throws IOException
	 */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationServiceException, IOException {
    	if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

		String json = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
        logger.info(json);
		JSONObject jsonObject;
        if (null !=json && !"".equals(json) && json.contains(loginExtendProperty.getUsername())){
        	jsonObject=JSONObject.parseObject(json);
		}else {
        	throw new AuthenticationServiceException("手机号错误");
		}
		return this.getAuthenticationManager().authenticate(new SmsAuthenticationToken(
                jsonObject.get(loginExtendProperty.getUsername()),request
        ));
    }
}
