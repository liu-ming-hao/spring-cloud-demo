package com.de.securityoauthdemo.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * LoginController
 *
 * @author 刘明浩
 * @Description 登录业务
 * @since 2020/12/25 14:29
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/page")
    public String toLogin(){
        return  "login";// templates/login.html
    }

    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    /**
     * 获取图形验证码
     */
    @RequestMapping("/code/image")
    public void imageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. 获取验证码字符串
        String code = defaultKaptcha.createText();
        // 2. 字符串把它放到session中
        request.getSession().setAttribute(SESSION_KEY , code);
        // 3. 获取验证码图片
        BufferedImage image = defaultKaptcha.createImage(code);
        // 4. 将验证码图片把它写出去
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

}
