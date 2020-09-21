package cn.tenfell.tools.nocontroller.utilsentity;

import java.lang.reflect.Method;

public class UriMap{
    Object service;
    Method method;
    boolean needLogin;
    Class<?>[] params;
    public Object getService() {
        return service;
    }
    public void setService(Object service) {
        this.service = service;
    }
    public Method getMethod() {
        return method;
    }
    public void setMethod(Method method) {
        this.method = method;
    }
    public boolean isNeedLogin() {
        return needLogin;
    }
    public void setNeedLogin(boolean needLogin) {
        this.needLogin = needLogin;
    }
    public Class<?>[] getParams() {
        return params;
    }
    public void setParams(Class<?>[] params) {
        this.params = params;
    }
}
