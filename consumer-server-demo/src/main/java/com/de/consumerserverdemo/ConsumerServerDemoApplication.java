package com.de.consumerserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient  //开启 服务发现:消费者
@EnableFeignClients(basePackages = {"com.de.consumerserverdemo.feign"}) //声明  跨服务调用  授权包
@EnableCircuitBreaker //声明  熔断器
public class ConsumerServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServerDemoApplication.class, args);
    }

    //启动该模块，spring容器创建和初始化一个RestTemplate  单例对象   用于服务间调用
    //负载均衡   Ribbon
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
