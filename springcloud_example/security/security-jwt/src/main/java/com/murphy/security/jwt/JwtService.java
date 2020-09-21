package com.murphy.security.jwt;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.murphy.security.properties.JwtPayloadProperties;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;

/**
 * jwt相关操作
 * @author dongsufeng
 * @version 4.0
 * @date 2019/12/2 2:49 PM
 */
@Component
@Log4j2
public class JwtService {

    @Autowired
    JwtPayloadProperties jwtPayloadProperties;


    /**
     * 生成令牌
     *
     * @param  .
     * @return .
     */
    public String generateToken(Authentication authentication) {
        return Jwts.builder()
                //jwt签发者
                .setIssuer(jwtPayloadProperties.getIssuer())
                // jwt所面向的用户
                .setSubject(authentication.getName())
                //接收jwt的一方
                .setAudience(jwtPayloadProperties.getAudience())
                //生效时间
                .setNotBefore(new Date(System.currentTimeMillis() - jwtPayloadProperties.getNotBeforeMinute() * 60 * 1000))
                //失效时间
                .setExpiration(new Date(System.currentTimeMillis() + jwtPayloadProperties.getExpirationMinute() * 60 * 1000))
                //签发时间
                .setIssuedAt(new Date())
                //秘钥签名
                .signWith(SignatureAlgorithm.HS512, jwtPayloadProperties.getSecret())
                .claim("userDTO", JSON.toJSONString(authentication.getPrincipal()))
                .compact();
    }
    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    public Claims getClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtPayloadProperties.getSecret()).parseClaimsJws(token).getBody();
    }

    /**
     * 从令牌中获取认证的唯一标识
     *
     * @param token 令牌
     * @return 用户id
     */
    public String getSubjectFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            log.error("", e);
            username = null;
        }
        return username;
    }

    /**
     * 验证令牌是否时间有效
     *
     * @param token 令牌
     * @return 是否有效
     */
    public Boolean validateToken(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            Date notBefore = claims.getNotBefore();
            return new Date().after(notBefore) && new Date().before(expiration);
        } catch (Exception e) {
            log.error("", e);
            return false;
        }
    }
}
