package cn.tenfell.tools.nocontroller.utils;

import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.AopUtils;

import java.lang.reflect.Field;
public class AopTargetUtils {
    public static <T> T getTarget(T proxy){
        try{
            if(!AopUtils.isAopProxy(proxy)) {
                return proxy;//不是代理对象
            }
            if(AopUtils.isJdkDynamicProxy(proxy)) {
                return (T)getJdkDynamicProxyTargetObject(proxy);
            } else { //cglib
                return (T)getCglibProxyTargetObject(proxy);
            }
        }catch (Exception e){
            return proxy;
        }

    }
    private static Object getCglibProxyTargetObject(Object proxy) throws Exception {
        Field field = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");
        field.setAccessible(true);
        Object dynamicAdvisedInterceptor = field.get(proxy);
        Field advised = dynamicAdvisedInterceptor.getClass().getDeclaredField("advised");
        advised.setAccessible(true);
        Object target = ((AdvisedSupport)advised.get(dynamicAdvisedInterceptor)).getTargetSource().getTarget();
        return target;
    }
    private static Object getJdkDynamicProxyTargetObject(Object proxy) throws Exception {
        Field field = proxy.getClass().getSuperclass().getDeclaredField("h");
        field.setAccessible(true);
        AopProxy aopProxy = (AopProxy) field.get(proxy);
        Field advised = aopProxy.getClass().getDeclaredField("advised");
        advised.setAccessible(true);
        Object target = ((AdvisedSupport)advised.get(aopProxy)).getTargetSource().getTarget();
        return target;
    }

}
