package net.chengp.gateway.filters;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


/**
 * 登录拦截
 *
 */
@Component
public class LoginFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		//ACL 访问控制列表
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		System.out.println("请求地址："+request.getRequestURI());
		if(request.getRequestURI().isEmpty() || !request.getRequestURI().startsWith("/gateway/login/")) {
			//请求地址为空或者不是login服务下面的地址就进行拦截
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Object run() throws ZuulException {
		//这里执行被拦截请求的业务逻辑,可使用JWT进行认证    json web token
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String token = request.getHeader("token");
		// token为空则在请求参数中拿
		if(StringUtils.isBlank(token)) {
			token = request.getParameter("token");
		}
		if(StringUtils.isBlank(token)) {
			ctx.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);//设置为401未认证
			ctx.setSendZuulResponse(false);
		}
		return null;
	}

	@Override
	public String filterType() {
		/**
		 * PRE_TYPE 前置
		 * POST_TYPE 后置
		 * ROUTE_TYPE 执行路由
		 * ERROR_TYPE 异常
		 */
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		//放在解码前执行
		return FilterConstants.PRE_DECORATION_FILTER_ORDER;
	}

}