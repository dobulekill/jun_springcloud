package cn.tenfell.tools.nocontroller.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.tenfell.tools.nocontroller.component.UriHandComponent;
import cn.tenfell.tools.nocontroller.config.NoControllerConfiguration;
import cn.tenfell.tools.nocontroller.inface.NoControllerInterface;
import cn.tenfell.tools.nocontroller.utils.ToolsUtils;
import cn.tenfell.tools.nocontroller.utilsentity.PoData;
import cn.tenfell.tools.nocontroller.utilsentity.R;
import cn.tenfell.tools.nocontroller.utilsentity.UriMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class WebController {
    public static Logger Logger = LoggerFactory.getLogger(WebController.class);
    @Autowired
    ApplicationContext ac;
    @Autowired
    NoControllerInterface noControllerInterface;
    @RequestMapping(value = "/selevt/{1}/{2}")
    public void selevt(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Exception e = null;
        try {
            UriMap uriMap= UriHandComponent.handMap.get(request.getRequestURI());
            int length = uriMap.getParams().length;
            if(length == 2){
                uriMap.getMethod().invoke(uriMap.getService(),request,response);
            }else if(length == 3){
                Class clazz = uriMap.getParams()[2];
                PoData poData = readRequestData(request);
                uriMap.getMethod().invoke(uriMap.getService(),request,response,dataToBean(poData,clazz));
            }
        } catch (Exception e2) {
            e = e2;
        }
        if(e != null){
            Logger.error(ToolsUtils.getExceptionMessage(e,false),e);
            throw e;
        }
    }
    @RequestMapping(value = "/json/{1}/{2}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object json(HttpServletRequest request){
        Object result = actionAjax(request,"json");
        return result;
    }
    @RequestMapping(value = "/jsonp/{1}/{2}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String jsonp(HttpServletRequest request){
        Object result = actionAjax(request,"jsonp");
        String callback = request.getParameter("callback");
        if(callback == null || "".equals(callback)){
            callback = "callback";
        }
        return callback+"("+ new JSONObject(result).toString() +")";
    }
    private Object actionAjax(HttpServletRequest request,String type){
        PoData poData = readRequestData(request);
        if(StrUtil.equals(type,"jsonp")){
            poData.remove("callback");
        }
        Object result = null;
        try {
            UriMap uriMap= UriHandComponent.handMap.get(request.getRequestURI());
            int length = uriMap.getParams().length;
            if(length == 1){
                result =uriMap.getMethod().invoke(uriMap.getService(),poData);
            }else if(length == 2){
                Class clazz = uriMap.getParams()[1];
                result =uriMap.getMethod().invoke(uriMap.getService(),poData,dataToBean(poData,clazz));
            }
        } catch (Exception e) {
            Logger.error(ToolsUtils.getExceptionMessage(e,false),e);
            result = R.error(e);
        }
        return result;
    }
    @RequestMapping(value = "/interface/doclist", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PoData doclist(HttpServletRequest request){
        PoData poData = new PoData();
        if("".equals(NoControllerConfiguration.key)){
            poData.put("flag",true);
            poData.put("list",UriHandComponent.interfaceList);
            poData.put("time",UriHandComponent.interfaceCreateTime);
            return poData;
        }
        if(request.getParameter("key") == null || "".equals(request.getParameter("key"))){
            poData.put("flag",false);
            poData.put("msg","请输入密钥");
            return poData;
        }
        if(!NoControllerConfiguration.key.equals(request.getParameter("key"))){
            poData.put("flag",false);
            poData.put("msg","密钥错误");
            return poData;
        }
        poData.put("flag",true);
        poData.put("list",UriHandComponent.interfaceList);
        poData.put("time",UriHandComponent.interfaceCreateTime);
        return poData;
    }

    private static PoData readRequestData(HttpServletRequest request){
        PoData poData = PoData.create();
        String requestBody = ServletUtil.getBody(request);
        poData.putAll(ServletUtil.getParamMap(request));
        if(StrUtil.isNotBlank(requestBody)){
            poData.put("requestBody",requestBody);
        }
        return poData;
    }
    private static <T> T dataToBean(PoData data,Class clazz){
        try{
            String requestBody = data.getStr("requestBody");
            if(StrUtil.isNotBlank(requestBody)){
                data = JSONUtil.parseObj(requestBody).toBean(PoData.class);
            }
            return (T)data.toBean(clazz);
        }catch (Exception e){
            return null;
        }
    }
}

