package com.opencloud.common.mybatis;

/**
 * @author Wujun
 */
public interface EnumConvertInterceptor {
    boolean convert(EntityMap map, String key, Object v);
}
