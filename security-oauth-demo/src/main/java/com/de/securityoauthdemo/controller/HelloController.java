package com.de.securityoauthdemo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
@RestController
@RequestMapping("/user")
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return  "hello";
    }


    /**
     * 获取当前登录用户信息, 方式2 注入 Authentication
     * @return
     */
//    @RequestMapping("/user/info")
//    @ResponseBody
//    public Object userInfo(Authentication authentication) {
//        return authentication.getPrincipal();
//    }



    /**
     * 获取当前登录用户信息, 方式3 注入 UesrDetails
     * @return
     */
    @GetMapping("/info")
    public Object userInfo2(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails; }
}
