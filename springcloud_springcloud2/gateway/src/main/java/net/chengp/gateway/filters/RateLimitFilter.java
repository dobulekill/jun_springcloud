package net.chengp.gateway.filters;

import org.apache.http.HttpStatus;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class RateLimitFilter extends ZuulFilter{
	
	private static final RateLimiter rateLimit = RateLimiter.create(1);//多实例下该值需要除以实例数

	@Override
	public boolean shouldFilter() {
		//这里可以引入ACL
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		if(!rateLimit.tryAcquire()) {//没拿到令牌就不继续执行
			RequestContext.getCurrentContext().setSendZuulResponse(false);
			RequestContext.getCurrentContext().setResponseStatusCode(HttpStatus.SC_BAD_REQUEST);
		}
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return -4;//最先执行
	}

}