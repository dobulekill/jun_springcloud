package com.murphy.security.filter.matcher;

import javax.servlet.http.HttpServletRequest;

/**
 * 匹配规则
 * @author dongsufeng
 * @version 4.0
 * @date 2019/12/3 2:31 PM
 */
public class RequestMatcher implements org.springframework.security.web.util.matcher.RequestMatcher {

    public RequestMatcher(){}

    private String ruleName;
    public RequestMatcher(String ruleName){
        this.ruleName=ruleName;
    }
    @Override
    public boolean matches(HttpServletRequest request) {
        String ruleName = request.getHeader("rule");
        if (this.ruleName.equals(ruleName)){
            return true;
        }
        return false;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
}
