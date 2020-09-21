package com.murphy.security.provider;

import java.util.Objects;

import com.murphy.security.service.UserExtendService;
import com.murphy.security.token.SmsAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import lombok.Data;

/**
 *
 * @author dongsufeng
 * @date 2019/12/03 12:01
 * @version 1.0
 */
@Data
public class SmsAuthenticationProvider implements AuthenticationProvider {

//    private UserDetailsService userDetailsService;
    private UserExtendService userExtendService;
    public SmsAuthenticationProvider(){}

    public SmsAuthenticationProvider( UserExtendService userExtendService){
//        this.userDetailsService=userDetailsService;
        this.userExtendService = userExtendService;
    }

	@Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        SmsAuthenticationToken authenticationToken = (SmsAuthenticationToken) authentication;
        /**
         * 调用 {@link UserDetailsService}
         */
        UserDetails user = userExtendService.loadUserByUsername((String)authenticationToken.getPrincipal());
        if (Objects.isNull(user)) {
            throw new InternalAuthenticationServiceException("手机号不存在");
        }
        if (!userExtendService.validate(authenticationToken.getRequest())){
            throw new InternalAuthenticationServiceException("验证码错误");
        }
        SmsAuthenticationToken authenticationResult = new SmsAuthenticationToken(user, user.getAuthorities());
        authenticationResult.setDetails(authenticationToken.getDetails());
        return authenticationResult;
    }

	@Override
	public boolean supports(Class<?> authentication) {
		return SmsAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
