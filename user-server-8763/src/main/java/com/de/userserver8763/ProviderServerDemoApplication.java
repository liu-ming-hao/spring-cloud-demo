package com.de.userserver8763;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient    //开启  服务发现:提供者
@MapperScan("com.de.userserver8763.dao") //扫描dao接口包
public class ProviderServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderServerDemoApplication.class, args);
    }

}
