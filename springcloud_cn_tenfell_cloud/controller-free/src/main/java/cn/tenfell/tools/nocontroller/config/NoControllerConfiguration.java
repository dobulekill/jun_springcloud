package cn.tenfell.tools.nocontroller.config;

import cn.tenfell.tools.nocontroller.filter.LoginHandlerInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages="cn.tenfell.tools.nocontroller"+"*..*")
public class NoControllerConfiguration implements WebMvcConfigurer {
    public static String key;
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> list = new ArrayList<String>();
        list.add("/**/*.*");
        registry.addInterceptor(new LoginHandlerInterceptor()).excludePathPatterns(list);
    }
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}
