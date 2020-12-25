package com.de.securityoauthdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient  //开启 服务发现:消费者
@EnableFeignClients(basePackages = {"com.de.securityoauthdemo.feign"}) //声明  跨服务调用  授权包
@EnableCircuitBreaker //声明  熔断器
public class SecurityOauthDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityOauthDemoApplication.class, args);
    }

}
