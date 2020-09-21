package com.forezp.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
//@PropertySource("classpath:swagger.properties")
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        ParameterBuilder builder=new ParameterBuilder();
        List<Parameter> parameters=new ArrayList<>();
        builder.name("Authorization")
                .description("Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NTgwMjQzOTYsInVzZXJfbmFtZSI6Im1peWFhMiIsImp0aSI6ImViMGYzMjg0LTlmZDgtNDY3ZS1iMjRlLTNjN2U4NWJlYmI2NSIsImNsaWVudF9pZCI6InVzZXItc2VydmljZSIsInNjb3BlIjpbInNlcnZpY2UiXX0.RpWfqKkw--q7y3xYqAvV0JNgO0fxgkugmMJTnfcGIunHvPVKFQzVjXibiLz-XITRfnsFxi65n_atskS2rh278ADBi8CEa-odJ8FofTx7wOmh7kw2nDfqMF-r43F-_x8y0qcm6SKrcLRw0mBQHpnXVwEas-Am4hzd_PzURfYKUHCHGj5YYiaCrERk5TG6vgZeAZgXQLYJQ-QfNihwiRkjjKLx_ECIhX1fiBBLlM4Yv7RGITFY9u8cEe9YJXaJDSo5RXRxn22iVh1hrWTOMVi6p1Vg-QAVqWYVqjRh8uTgeKwyDrrCbAUaEzQbraaqCIkkZFck9hro_Ce-WprbKBqp1Q")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build();
        parameters.add(builder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.forezp.userservice.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameters)
                .apiInfo(apiInfo());
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("简单优雅的restful风格")
                .termsOfServiceUrl("http://blog.csdn.net/forezp")
                .version("1.0")
                .build();
    }
}
