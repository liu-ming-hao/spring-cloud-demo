package com.de.securityoauthdemo.controller;

import com.de.publicpackage.result.CodeMsg;
import com.de.publicpackage.result.Result;
import com.de.securityoauthdemo.mobile.SmsSend;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @Autowired
    SmsSend smsSend;
    public static final String SESSION_KEY_MOBILE = "SESSION_KEY_MOBILE_CODE";
    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";
    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/page")
    public String toLogin(){
        return  "login";// templates/login.html
    }

    /**
     * 手机验证码登陆页
     */
    @RequestMapping("/mobile/page")
    public String toMobilePage(){
        return "login-mobile";
    }

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

    /**
     * 发送手机验证码
     * @return
     */
    @ResponseBody //响应json字符串
    @RequestMapping("/code/mobile")
    public Result smsCode(HttpServletRequest request) {
        // 1. 生成一个手机验证码
        String code = RandomStringUtils.randomNumeric(4);
        // 2. 将手机验证码保存到session中
        request.getSession().setAttribute(SESSION_KEY_MOBILE, code);
        // 3. 发送验证码到用户手机上
        String mobile = request.getParameter("mobile");
        smsSend.sendSms(mobile, code);
        return Result.success(new CodeMsg(200,code));
    }
}
