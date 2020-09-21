package cn.tenfell.tools.nocontroller.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface InterfaceModule {
    //模块名称
    String value() default "";
}
