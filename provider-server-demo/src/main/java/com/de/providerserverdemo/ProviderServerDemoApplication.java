package com.de.providerserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient    //开启  服务发现:提供者
public class ProviderServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderServerDemoApplication.class, args);
    }

}
