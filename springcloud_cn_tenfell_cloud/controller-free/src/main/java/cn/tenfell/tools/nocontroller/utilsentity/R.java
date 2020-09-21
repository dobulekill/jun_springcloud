package cn.tenfell.tools.nocontroller.utilsentity;

import cn.hutool.core.util.StrUtil;
import cn.tenfell.tools.nocontroller.utils.ToolsUtils;

import java.util.HashMap;

public class R<T> extends HashMap<String,Object> {
    private static final long serialVersionUID = 1L;
    public static <T> R<T> page(T data,Long total) {
        return restResult(data,total, ResponseStatus.SUCCESS, "操作成功",null);
    }
    public static <T> R<T> ok() {
        return restResult(null, null,ResponseStatus.SUCCESS, "操作成功",null);
    }
    public static <T> R<T> okData(T data) {
        return restResult(data,null, ResponseStatus.SUCCESS, "操作成功",null);
    }
    public static <T> R<T> ok(T data,String msg) {
        if(StrUtil.isBlank(msg)){
            return okData(data);
        }
        return restResult(data,null, ResponseStatus.SUCCESS, msg,null);
    }
    public static <T> R<T> ok(String msg) {
        if(StrUtil.isBlank(msg)){
            return ok();
        }
        return restResult(null,null, ResponseStatus.SUCCESS, msg,null);
    }
    public static <T> R<T> error(String error,String msg) {
        return restResult(null,null, ResponseStatus.FAILED, msg,error);
    }
    public static <T> R<T> error(Exception e) {
        String error = ToolsUtils.getExceptionMessage(e,true);
        String msg = ToolsUtils.getExceptionMessage(e,false);
        return error(error,msg);
    }
    public static <T> R<T> failed() {
        return restResult(null,null, ResponseStatus.FAILED, "操作失败",null);
    }
    public static <T> R<T> failedData(T data) {
        return restResult(data,null, ResponseStatus.FAILED, "操作失败",null);
    }
    public static <T> R<T> failed(T data,String msg) {
        if(StrUtil.isBlank(msg)){
            return failedData(data);
        }
        return restResult(data,null, ResponseStatus.FAILED, msg,null);
    }
    public static <T> R<T> failed(String msg) {
        if(StrUtil.isBlank(msg)){
            return failed();
        }
        return restResult(null,null, ResponseStatus.FAILED,msg,null);
    }
    private static <T> R<T> restResult(T data, Long total, ResponseStatus status, String msg,String error) {
        R<T> r = new R<T>();
        r.set("status", status)
        .set(total!=null,"total", total)
        .set(data!=null,"data", data)
        .set(error!=null,"error", error)
        .set("msg", msg);
        return r;
    }
    public R set(String attr,Object object){
        return set(true,attr,object);
    }
    public R set(boolean flag,String attr,Object object){
        if(flag){
            this.put(attr,object);
        }
        return this;
    }
}
