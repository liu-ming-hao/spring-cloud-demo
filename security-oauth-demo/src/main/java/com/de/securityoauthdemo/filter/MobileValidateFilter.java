package com.de.securityoauthdemo.filter;

import com.de.securityoauthdemo.component.CustomAuthenticationFailureHandler;
import com.de.securityoauthdemo.controller.LoginController;
import com.de.securityoauthdemo.exception.ConsumerAuthenticationException;
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
 * 校验用户输入的手机验证码是否正确
 * OncePerRequestFilter : OncePerRequestFilter顾名思义，他能够确保在一次请求只通过一次filter，而不需要重复执行。
 */
@Component // 不要少了
public class MobileValidateFilter extends OncePerRequestFilter {
    @Autowired
    CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1. 判断 请求是否为/mobile/form手机登录，且post请求
        if("/login/mobile/form".equals(request.getRequestURI())
                && "post".equalsIgnoreCase(request.getMethod())) {
            try {
                // 校验验证码合法性
                validate(request);
            }catch (AuthenticationException e) {
                // 交给失败处理器进行处理异常
                customAuthenticationFailureHandler.onAuthenticationFailure(request, response, e);
                // 一定要记得结束
                return;
            }
        }
        // 放行
        filterChain.doFilter(request, response);
    }
    private void validate(HttpServletRequest request) {
        // 先获取seesion中的验证码
        String sessionCode = (String)request.getSession().getAttribute(LoginController.SESSION_KEY_MOBILE);
        // 获取用户输入的验证码
        String inpuCode = request.getParameter("content");
        // 判断是否正确
        if(StringUtils.isBlank(inpuCode)) {
            throw new ConsumerAuthenticationException("验证码不能为空");
        }
        if(!inpuCode.equalsIgnoreCase(sessionCode)) {
            throw new ConsumerAuthenticationException("验证码输入错误");
        }
    }
}
