package cn.tenfell.tools.nocontroller.inface;

import javax.servlet.http.HttpServletRequest;

public interface NoControllerInterface {
    Object getLoginUser(HttpServletRequest request);
}
