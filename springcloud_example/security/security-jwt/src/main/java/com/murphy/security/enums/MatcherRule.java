package com.murphy.security.enums;

/**
 * @author Wujun
 * @version 4.0
 * @date 2019/12/3 2:54 PM
 */
public enum MatcherRule {
    /**
     * 短信验证码
     */
    SMS("sms"),
    /**
     * 用户名密码
     */
    USERNAME_PASSWORD("up");

    private String ruleName;

    MatcherRule(String ruleName){
        this.ruleName=ruleName;
    }

    public String getRuleName() {
        return ruleName;
    }
}
