package cn.tenfell.tools.nocontroller.component;

import cn.hutool.json.JSONUtil;
import cn.tenfell.tools.nocontroller.annotation.InterfaceDoc;
import cn.tenfell.tools.nocontroller.annotation.InterfaceModule;
import cn.tenfell.tools.nocontroller.annotation.NeedLogin;
import cn.tenfell.tools.nocontroller.inface.NoControllerInterface;
import cn.tenfell.tools.nocontroller.utils.AopTargetUtils;
import cn.tenfell.tools.nocontroller.utilsentity.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class UriHandComponent implements ApplicationContextAware {
    public static List<InterfaceDocEntity> interfaceList = new ArrayList<InterfaceDocEntity>();
    public static String interfaceCreateTime;
    public static Map<String, UriMap> handMap = new HashMap<String,UriMap>();
    public static NoControllerInterface noControllerInterface;
    @Autowired
    NoControllerInterface noControllerInterfaceService;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        UriHandComponent.noControllerInterface = noControllerInterfaceService;
        String[] conMappings = {"json","jsonp"};
        Map<String, Object> serviceMap =  applicationContext.getBeansWithAnnotation(Service.class);
        Set<String> keys = serviceMap.keySet();
        List<ServiceCacheData> serviceCacheDataList = new ArrayList<ServiceCacheData>();
        for(String key:keys){
            //代理对象,用于事务控制
            Object service = serviceMap.get(key);
            //原对象,用于获取注解
            Object serviceTarget = AopTargetUtils.getTarget(service);
            ServiceCacheData serviceCacheData = new ServiceCacheData();
            serviceCacheData.setService(serviceTarget);
            serviceCacheData.setServiceName(key);
            List<Method> methodList = new ArrayList<Method>();
            Method[] methods = serviceTarget.getClass().getDeclaredMethods();
            for(Method method:methods){
                Class<?>[] types = method.getParameterTypes();
                boolean hasMethod = false;
                int type = getType(types);
                if(type == 1){
                    hasMethod = true;
                    //表示要处理的json,jsonp
                    UriMap uriMap = new UriMap();
                    uriMap.setService(service);
                    uriMap.setMethod(method);
                    uriMap.setParams(types);
                    NeedLogin needLogin = method.getAnnotation(NeedLogin.class);
                    uriMap.setNeedLogin(needLogin != null);
                    for(String conMapping:conMappings){
                        String mapKey = "/"+conMapping+"/"+key+"/"+method.getName();
                        handMap.put(mapKey,uriMap);
                    }
                }else if(type == 2){
                    hasMethod = true;
                    //表示要处理的selevt
                    UriMap uriMap = new UriMap();
                    uriMap.setService(service);
                    uriMap.setMethod(method);
                    uriMap.setParams(types);
                    NeedLogin needLogin = method.getAnnotation(NeedLogin.class);
                    uriMap.setNeedLogin(needLogin != null);
                    String mapKey = "/selevt/"+key+"/"+method.getName();
                    handMap.put(mapKey,uriMap);
                }
                if(hasMethod){
                    methodList.add(method);
                }
            }
            serviceCacheData.setMethods(methodList);
            serviceCacheDataList.add(serviceCacheData);
        }
        setInterfaceList(serviceCacheDataList);
    }
    private static void setInterfaceList(List<ServiceCacheData> list){
        String[] conMappings = {"json","jsonp"};
        for(ServiceCacheData serviceCacheData:list){
            InterfaceDocEntity interfaceDocEntity = null;
            List<InterfaceDocChild> interfaceDocChildren = null;
            Object service = serviceCacheData.getService();
            List<Method> methodList = serviceCacheData.getMethods();
            for(Method method:methodList){
                Class<?>[] types = method.getParameterTypes();
                InterfaceDoc interfaceDoc = method.getAnnotation(InterfaceDoc.class);
                int type = getType(types);
                boolean hasDoc = interfaceDoc != null && (type==1 || type==2);
                if(!hasDoc){
                    continue;
                }
                if(interfaceDocEntity == null){
                    interfaceDocEntity = new InterfaceDocEntity();
                    interfaceDocChildren = new ArrayList<InterfaceDocChild>();
                    String moduleName = serviceCacheData.getServiceName();
                    InterfaceModule interfaceModule = service.getClass().getAnnotation(InterfaceModule.class);
                    if(interfaceModule != null && !"".equals(interfaceModule.value())){
                        moduleName = interfaceModule.value();
                    }
                    interfaceDocEntity.setName(moduleName);
                }
                InterfaceDocChild interfaceDocChild = new InterfaceDocChild();
                try{
                    Object returnObj = method.getReturnType().newInstance();
                    interfaceDocChild.setReturnData(JSONUtil.toJsonStr(returnObj));
                }catch (Exception e){
                }
                String interfaceName = method.getName();
                if(interfaceDoc != null && !"".equals(interfaceDoc.name())){
                    interfaceName = interfaceDoc.name();
                }
                interfaceDocChild.setName(interfaceName);
                List<InterfaceParams> interfaceParamsList = new ArrayList<InterfaceParams>();
                String[] params = interfaceDoc.params();
                for(String param:params){
                    if(param == null || "".equals(param.trim())){
                        continue;
                    }
                    String[] paramValues = param.split(interfaceDoc.separator(),3);
                    if(paramValues.length != 3){
                        continue;
                    }
                    InterfaceParams interfaceParams = new InterfaceParams();
                    interfaceParams.setParam(paramValues[0]);
                    interfaceParams.setIsNeed(paramValues[1]);
                    interfaceParams.setParamDesc(paramValues[2]);
                    interfaceParamsList.add(interfaceParams);
                }
                interfaceDocChild.setParams(interfaceParamsList);
                List<String> urlList = new ArrayList<String>();
                if(type == 1){
                    //表示要处理的json,jsonp
                    for(String conMapping:conMappings){
                        String mapKey = "/"+conMapping+"/"+serviceCacheData.getServiceName()+"/"+method.getName();
                        urlList.add(mapKey);
                    }
                }else if(type == 2){
                    //表示要处理的selevt
                    String mapKey = "/selevt/"+serviceCacheData.getServiceName()+"/"+method.getName();
                    urlList.add(mapKey);
                }
                interfaceDocChild.setUrlList(urlList);
                interfaceDocChildren.add(interfaceDocChild);
            }
            if(interfaceDocEntity != null){
                interfaceDocEntity.setList(interfaceDocChildren);
                interfaceList.add(interfaceDocEntity);
            }
        }
        interfaceCreateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    private static int getType(Class<?>[] types){
        int type = 0;
        if((types.length == 1 || types.length == 2) && types[0] == PoData.class){
            type = 1;
        }else if((types.length == 2 || types.length == 3) && types[0] == HttpServletRequest.class && types[1] == HttpServletResponse.class){
            type = 2;
        }
        return type;
    }

}

