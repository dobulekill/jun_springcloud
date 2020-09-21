package cn.tenfell.tools.nocontroller.annotation;
import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface InterfaceDoc {
    //接口名称
    String name() default "";
    //参数集合 请使用分隔符分开 如{ "name,Y,姓名" }
    String[] params() default {};
    //参数分割符
    String separator() default ",";

}

