package cn.tenfell.tools.nocontroller.utils;

import cn.hutool.core.exceptions.ExceptionUtil;

public class ToolsUtils {
    public static String getExceptionMessage(Throwable e,boolean isAll) {
        String msg;
        Throwable temp = ExceptionUtil.getRootCause(e);
        if(isAll){
            msg = ExceptionUtil.stacktraceToString(temp);
        }else{
            msg = temp.getMessage();
        }
        return msg;
    }
}
