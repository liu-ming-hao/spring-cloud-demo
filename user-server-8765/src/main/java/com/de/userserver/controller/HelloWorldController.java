package com.de.userserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * HelloWorldController
 *
 * @author 刘明浩
 * @Description   提供一个RestApi接口服务，后面服务消费者会调用这个测试API服务
 * @since 2020/12/8 9:16
 */
@RestController
@RequestMapping("/provider")
@Slf4j
public class HelloWorldController {
    @Value("${server.port}")
    String serverPort;

    @GetMapping("/hi")
    public String home(@RequestParam String name){
        try{
            log.info("provader-server/hi" + name + ", i am from port" + serverPort);
            return "provader-server/hi" + name + ", i am from port:" + serverPort;
        }catch (Exception e){
            return "error";
        }
    }
}
