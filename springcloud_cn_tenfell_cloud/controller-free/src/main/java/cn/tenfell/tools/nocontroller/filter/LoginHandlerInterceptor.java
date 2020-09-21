package cn.tenfell.tools.nocontroller.filter;

import cn.hutool.json.JSONUtil;
import cn.tenfell.tools.nocontroller.component.UriHandComponent;
import cn.tenfell.tools.nocontroller.utilsentity.R;
import cn.tenfell.tools.nocontroller.utilsentity.ResponseStatus;
import cn.tenfell.tools.nocontroller.utilsentity.UriMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginHandlerInterceptor implements HandlerInterceptor {
    public static Logger Logger = LoggerFactory.getLogger(LoginHandlerInterceptor.class);
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        UriMap uriMap = UriHandComponent.handMap.get(request.getRequestURI());
        if(uriMap == null){
            //说明接口不存在
            if("/interface/doclist".equals(request.getRequestURI())){
                return true;
            }
            try{
                Object noMethod = R.failed("此方法不存在");
                response.setContentType("application/json;charset=UTF-8");
                response.getOutputStream().write(JSONUtil.toJsonStr(noMethod).getBytes());
            }catch (Exception e){
                Logger.error("方法不存在异常");
            }
            return false;
        }
        if(uriMap.isNeedLogin()){
            //说明此接口需要登录
            Object user = UriHandComponent.noControllerInterface.getLoginUser(request);
            if(user == null){
                try{
                    Object noLogin = R.failed("用户没有登录").set("status", ResponseStatus.NOLOGIN);
                    response.setContentType("application/json;charset=UTF-8");
                    response.getOutputStream().write(JSONUtil.toJsonStr(noLogin).getBytes());
                }catch (Exception e){
                    Logger.error("用户未登录异常");
                }
                return false;
            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
