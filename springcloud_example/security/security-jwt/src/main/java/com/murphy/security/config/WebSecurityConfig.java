package com.murphy.security.config;

import com.alibaba.fastjson.JSONObject;
import com.murphy.security.filter.SmsFilter;
import com.murphy.security.properties.LoginExtendProperty;
import com.murphy.security.provider.SmsAuthenticationProvider;
import com.murphy.security.service.UserExtendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.murphy.security.filter.JwtAuthenticationTokenFilter;
import com.murphy.security.filter.UsernamePasswordFilter;
import com.murphy.security.handler.SimpleAuthenticatingFailureHandler;
import com.murphy.security.handler.SimpleAuthenticatingSuccessHandler;
import com.murphy.security.properties.JwtAuthFilterProperty;

import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackages = {"com.murphy.security"})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthFilterProperty jwtAuthFilterProperty;

    @Autowired
    LoginExtendProperty loginExtendProperty;

    @Autowired
    private SimpleAuthenticatingSuccessHandler simpleAuthenticatingSuccessHandler;

    @Autowired
    private SimpleAuthenticatingFailureHandler simpleAuthenticatingFailureHandler;

    @Autowired
    UserExtendService userExtendService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * HTTP请求安全处理
     * token请求授权
     *
     * @param httpSecurity .
     * @throws Exception .
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {


        // 由于使用的是JWT，我们这里不需要csrf
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry
                = httpSecurity.csrf().disable()
                //未授权处理
                .exceptionHandling().authenticationEntryPoint((request, response, authException) -> {
                    logger.error("未授权uri={}",request.getRequestURI());
                    response.setHeader("Access-Control-Allow-Origin", "*");
                    response.setStatus(200);
                    Map<String,Object> map=new HashMap<>(3);
                    map.put("code","401");
                    map.put("message","未授权uri="+request.getRequestURI());
                    map.put("data",Boolean.FALSE);
                    response.setCharacterEncoding("UTF-8");
                    JSONObject.writeJSONString(response.getWriter(),map);
                })
                // 基于token，所以不需要session
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests();
        //白名单，无需token
        String[] urls = jwtAuthFilterProperty.getExceptUrl().split(",");
        for (String url : urls) {
            // 对于获取token的rest api要允许匿名访问
            expressionInterceptUrlRegistry.antMatchers(url).permitAll();
        }
        expressionInterceptUrlRegistry
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated();
        // 添加JWT filter
        //将token验证添加在密码验证前面
        httpSecurity.addFilterBefore(getJwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        httpSecurity.addFilterBefore(getUsernamePasswordFilter(), JwtAuthenticationTokenFilter.class);
        httpSecurity.authenticationProvider(new SmsAuthenticationProvider(userExtendService)).addFilterBefore(getSmsFilter(),UsernamePasswordFilter.class);
        // 禁用缓存
        httpSecurity.headers().cacheControl();
    }
	/**
	 * 	密码加密
	 * @author Wujun
	 * @return org.springframework.security.crypto.password.PasswordEncoder
	 * @date 2019/9/17 18:39
	 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter getJwtAuthenticationTokenFilter() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    public AuthenticationManager getManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public UsernamePasswordFilter getUsernamePasswordFilter() throws Exception {
        UsernamePasswordFilter userLoginFilter = new UsernamePasswordFilter(getManagerBean(), loginExtendProperty.getLoginUrl());
        userLoginFilter.setAuthenticationSuccessHandler(simpleAuthenticatingSuccessHandler);
        userLoginFilter.setAuthenticationFailureHandler(simpleAuthenticatingFailureHandler);
        return userLoginFilter;
    }

    @Bean
    public SmsFilter getSmsFilter() throws Exception{
        SmsFilter smsFilter=new SmsFilter(getManagerBean(), loginExtendProperty.getLoginUrl());
        smsFilter.setAuthenticationSuccessHandler(simpleAuthenticatingSuccessHandler);
        smsFilter.setAuthenticationFailureHandler(simpleAuthenticatingFailureHandler);
        return smsFilter;
    }

}
