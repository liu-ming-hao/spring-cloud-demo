package com.de.providerserverdemotwo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient   //开启   服务发现
@MapperScan("com.de.providerserverdemotwo.dao")
public class ProviderServerDemoTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderServerDemoTwoApplication.class, args);
    }

}
