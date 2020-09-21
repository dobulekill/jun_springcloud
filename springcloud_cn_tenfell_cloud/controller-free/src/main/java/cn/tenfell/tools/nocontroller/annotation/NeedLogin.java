package cn.tenfell.tools.nocontroller.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface NeedLogin {
}
