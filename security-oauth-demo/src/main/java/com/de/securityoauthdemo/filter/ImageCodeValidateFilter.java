package com.de.securityoauthdemo.filter;

import com.de.securityoauthdemo.component.CustomAuthenticationFailureHandler;
import com.de.securityoauthdemo.controller.LoginController;
import com.de.securityoauthdemo.exception.ConsumerAuthenticationException;
import com.de.securityoauthdemo.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ImageCodeValidateFilter
 *
 * @author 刘明浩
 * @Description OncePerRequestFilter类: 所有请求之前被调用一次
 * @since 2020/12/26 13:05
 */
@Component("imageCodeValidateFilter")
public class ImageCodeValidateFilter extends OncePerRequestFilter {
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    CustomAuthenticationFailureHandler customAuthenticationFailureHandler;


    @Override
    protected void doFilterInternal(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            FilterChain filterChain) throws ServletException, IOException {
        // 1. 如果是post方式 的登录请求和是登录的url，则校验输入的验证码是否正确
        if(securityProperties.getAuthentication().getLoginProcessingUrl()
                .equals(httpServletRequest.getRequestURI())
                && httpServletRequest.getMethod().equalsIgnoreCase("post")) {
            try {
                // 校验验证码合法性
                validate(httpServletRequest);
            }catch (AuthenticationException e) {
                // 交给失败处理器进行处理异常
                customAuthenticationFailureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
                // 一定要记得结束,不然会继续往下执行
                return;
            }
        }
        // 校验完毕,放行请求
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    /**
     * 校验验证码
     * @param request
     * @throws ServletException
     */
    private void validate(HttpServletRequest request){
        // 先获取seesion中的验证码
        String sessionCode = (String)request.getSession().getAttribute(LoginController.SESSION_KEY);
        // 获取用户输入的验证码
        String inpuCode = request.getParameter("verificationCode");
        // 判断是否正确
        if(StringUtils.isBlank(inpuCode)) {
            throw new ConsumerAuthenticationException("验证码不能为空");
        }

        if(!inpuCode.equalsIgnoreCase(sessionCode)) {
            throw new ConsumerAuthenticationException("验证码输入错误");
        }
    }

}
