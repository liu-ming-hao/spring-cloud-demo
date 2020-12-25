package com.de.securityoauthdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * HelloController
 *
 * @author 刘明浩
 * @Description
 * @since 2020/12/25 8:25
 */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return  "hello";
    }
}
