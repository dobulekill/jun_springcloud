package com.opencloud.common.annotation;

import java.lang.annotation.*;

/**
 * table别名
 * @author Wujun
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface TableAlias {
    String value();
}
