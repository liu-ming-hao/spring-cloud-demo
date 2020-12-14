package com.de.zuulserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient //注册服务  发现
@EnableZuulProxy //声明  网关zuul  代理
public class ZuulServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerDemoApplication.class, args);
    }

}
