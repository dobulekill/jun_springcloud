package com.murphy.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Claims;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.murphy.security.properties.JwtAuthFilterProperty;
import com.murphy.security.jwt.JwtService;

@Log4j2
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtAuthFilterProperty jwtAuthFilterProperty;

    /**
     * 过滤器逻辑
     *
     * @param request  .
     * @param response .
     * @param chain    .
     * @throws ServletException .
     * @throws IOException      ,
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader(this.jwtAuthFilterProperty.getHeader());
        String tokenHead = this.jwtAuthFilterProperty.getTokenHead();
        if (authHeader != null && authHeader.startsWith(tokenHead)) {
            String authToken = authHeader.substring(tokenHead.length());
            if (jwtService.validateToken(authToken)) {
                Claims claimsFromToken = jwtService.getClaimsFromToken(authToken);
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(claimsFromToken.getSubject(), null, null);
                String  userDTO = claimsFromToken.get("userDTO", String.class);
                log.info("=======lanjie={}",userDTO);
                request.setAttribute("userInfoDTO", userDTO);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }
}
