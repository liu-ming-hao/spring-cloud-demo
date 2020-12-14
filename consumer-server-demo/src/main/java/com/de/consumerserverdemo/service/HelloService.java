package com.de.consumerserverdemo.service;

import com.de.consumerserverdemo.feign.UserFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * HelloService
 *
 * @author 刘明浩
 * @Description
 * @since 2020/12/8 10:54
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserFeignClient userFeignClient;

    //请求熔断注解 ,服务调用异常 执行注解中 方法
    @HystrixCommand(fallbackMethod = "hiServiceFailBack")
    public String hiService(String name){
        return restTemplate.getForObject("http://provider-service-demo/provider/hi?name=" + name,String.class);
    }

    public String hiServiceFailBack(String name){
        return "用户 " + name + "调用provider服务熔断，触发降级处理";
    }

    public String hiServiceFeign(String name){
        return userFeignClient.home(name);
    }
}
