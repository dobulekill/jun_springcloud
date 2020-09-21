package cn.tenfell.tools.nocontroller.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns="/**",filterName="bodyRequestFilter")
public class BodyReaderRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;
        BodyReaderRequestWrapper requestWrapper  = new BodyReaderRequestWrapper(request);
        if(requestWrapper == null){
            filterChain.doFilter(request,response);
        }else {
            filterChain.doFilter(requestWrapper,response);
        }
    }

    @Override
    public void destroy() {

    }
}