package com.itqf.smsplatform.cache.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * author:zouningsss
 * date:Created in 2020/3/15 15:41
 * description:
 */

@Configuration
public class SwaggerConfig {
    @Value("${swagger.title}")
    private String title;
    @Value("${swagger.description}")
    private String description;
    @Value("${swagger.contactName}")
    private String contactName;
    @Value("${swagger.email}")
    private String email;
    @Value("${swagger.licenseUrl}")
    private String licenseUrl;
    @Value("${swagger.version}")
    private String version;
    @Value("${swagger.basePackge}")
    private String basePackge;

    @Bean
    public Docket docket(ApiInfo apiInfo) {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo)
                .select().apis(RequestHandlerSelectors.basePackage(basePackge)).paths(PathSelectors.any()).build();
    }


    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .contact(new Contact(contactName, null, email))
                .version(version)
                .licenseUrl(licenseUrl)
                .build();

    }

}
