package com.forezp.zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
@EnableEurekaClient
//@EnableZipkinStreamServer
public class ZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class, args);
    }

//    @Bean
//    public MySQLStorage mySQLStorage(DataSource dataSource) {
//        return MySQLStorage.builder().datasource(dataSource)
//                .executor(Runnable::run).build();
//    }

}
