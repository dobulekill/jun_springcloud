package cn.tenfell.tools.nocontroller.utilsentity;

import java.lang.reflect.Method;
import java.util.List;
public class ServiceCacheData {
    String serviceName;
    Object service;
    List<Method> methods;
    public Object getService() {
        return service;
    }

    public void setService(Object service) {
        this.service = service;
    }

    public List<Method> getMethods() {
        return methods;
    }

    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
