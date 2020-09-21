package cn.tenfell.tools.nocontroller.component;

import cn.hutool.core.lang.Assert;
import cn.tenfell.tools.nocontroller.utilsentity.R;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
public class BaseService {
    public <T> R<T> page(T data,Long total) {
        return R.page(data,total);
    }
    public <T> R<T> ok() {
        return R.ok();
    }
    public <T> R<T> okData(T data) {
        return R.okData(data);
    }
    public <T> R<T> ok(String msg) {
        return R.ok(msg);
    }
    public <T> R<T> ok(T data,String msg) {
        return R.ok(data,msg);
    }
    public <T> R<T> failed() {
        return R.failed();
    }
    public <T> R<T> failed(String msg) {
        return R.failed(msg);
    }
    public <T> T getUser(){
        Assert.notNull(UriHandComponent.noControllerInterface);
        return (T)UriHandComponent.noControllerInterface.getLoginUser(getRequest());
    }
    public HttpServletRequest getRequest(){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        Assert.notNull(ra);
        HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
        return request;
    }
    public HttpSession getSession() {
        HttpServletRequest request = getRequest();
        Assert.notNull(request);
        HttpSession session = request.getSession();
        return session;
    }
}
