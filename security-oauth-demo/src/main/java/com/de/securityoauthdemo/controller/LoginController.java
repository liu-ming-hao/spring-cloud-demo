package com.de.securityoauthdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * LoginController
 *
 * @author 刘明浩
 * @Description 登录业务
 * @since 2020/12/25 14:29
 */
@Controller
public class LoginController {
    @RequestMapping("/login/page")
    public String toLogin(){
        return  "login";// templates/login.html
    }
}
