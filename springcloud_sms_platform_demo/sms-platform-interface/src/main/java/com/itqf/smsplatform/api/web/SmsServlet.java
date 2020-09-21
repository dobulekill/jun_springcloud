package com.itqf.smsplatform.api.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itqf.smsplatform.api.bean.BaseResult;
import com.itqf.smsplatform.api.exception.SmsInterfaceException;
import com.itqf.smsplatform.api.service.SmsCheckService;
import com.itqf.smsplatform.common.constants.InterfaceExceptionDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author:zouningsss
 * date:Created in 2020/3/16 13:45
 * description:
 * 当前类是给客户或者是第三平台做接入用的,主要是判断接入方是否有资格发送短信
 * 需要校验发送者的账号和密码,设置的 ip 和发送的 ip 的是不是一样的
 * 发送短信的唯一标识是不是正确的(通过我们这个接口发送的短信我们需要将结果告诉发送方,那么在告诉他的时候我们需要清晰的告诉它这是哪条短信的发送结果
 * 类似于我们做支付的时候,商户会将订单号发到支付平台,支付平台完成后会再将订单号返回给商户,这样子商户就知道支付结果了)
 * 当然还要判断手机号
 */

@WebServlet(urlPatterns = "/smsinterface", name = "SmsServlet")
public class SmsServlet extends HttpServlet {

    @Autowired
    private SmsCheckService smsCheckService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        String clientID = req.getParameter("clientID");
        String srcID = req.getParameter("srcID");
        String mobile = req.getParameter("mobile");
        String content = req.getParameter("content");
        String pwd = req.getParameter("pwd");//此处应该是一个原始密码
        String ip = getRealIp(req);//获取 ip


        //校验上面传递过来的数据
        //获取真实的数据
        BaseResult baseResult = new BaseResult();
        try {
            //因为内部校验的时候失败是通过抛出异常来进行的,所以我们要捕获异常
            smsCheckService.checkSms(clientID, pwd, srcID, ip, content, mobile);
            //创建返回结果的对象
            baseResult.setCode(InterfaceExceptionDict.RETURN_STATUS_SUCCESS);
            baseResult.setMsg("success");

            resp.getWriter().write(objectMapper.writeValueAsString(baseResult));
        } catch (Exception e) {
            e.printStackTrace();
            //给返回结果的对象赋值
            baseResult.setCode(((SmsInterfaceException) e).getCode());
            baseResult.setMsg(((SmsInterfaceException) e).getMsg());
            resp.getWriter().write(objectMapper.writeValueAsString(baseResult));
        }


    }

    /**
     * 获取IP
     *
     * @param req
     * @return
     */
    public static String getRealIp(HttpServletRequest req) {
        String ip = null;
        //获取请求头中标记的真正的ip
        String xIp = req.getHeader("X-Real-IP");
        //我们可能会有多次的反向代理
        String xFor = req.getHeader("X-Forwarded-For");
        //这个 ip 不为空且不是 unknown
        if (!StringUtils.isEmpty(xFor) && !"unknow".equalsIgnoreCase(xFor)) {
            int index = xFor.indexOf(",");//获取第一个,的位置
            if (index > 0) {
                return xFor.substring(0, index);
            }
            return xFor;
        }

        ip = xIp;//有可能这个 ip 也没有

        //当前 ip 是空的
        if (StringUtils.isEmpty(ip) || "unknow".equalsIgnoreCase(ip)) {
            ip = req.getHeader("Proxy-Client-IP");
        }
        //上面获取的有可能还是空的
        if (StringUtils.isEmpty(ip) || "unknow".equalsIgnoreCase(ip)) {
            ip = req.getHeader("WL-Proxy-Client-IP");
        }

        if (StringUtils.isEmpty(ip) || "unknow".equalsIgnoreCase(ip)) {
            ip = req.getHeader("HTTP_CLIENT_IP");
        }

        if (StringUtils.isEmpty(ip) || "unknow".equalsIgnoreCase(ip)) {
            ip = req.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (StringUtils.isEmpty(ip) || "unknow".equalsIgnoreCase(ip)) {
            ip = req.getRemoteAddr();
        }

        return ip;

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }


}
