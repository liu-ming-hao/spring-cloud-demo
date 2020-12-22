package com.de.backinterfaceserver.controller;


import com.de.backinterfaceserver.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author 刘明浩
 * @Description
 * @since 2020/12/8 10:28
 */
@RestController
@RequestMapping("/consumer")
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/hi")
    public String home(@RequestParam String name){
        return helloService.hiService(name);
    }

    @RequestMapping("/hifeign")
    public String homeFeign(@RequestParam String name) {
        return  helloService.hiServiceFeign(name);
    }
}
