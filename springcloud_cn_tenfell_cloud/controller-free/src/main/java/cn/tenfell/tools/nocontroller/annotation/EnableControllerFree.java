package cn.tenfell.tools.nocontroller.annotation;

import cn.tenfell.tools.nocontroller.config.NoControllerConfiguration;
import cn.tenfell.tools.nocontroller.config.NoControllerRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({NoControllerConfiguration.class, NoControllerRegistrar.class})
public @interface EnableControllerFree {
    String key() default "";
}
