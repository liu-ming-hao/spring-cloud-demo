package com.de.securityoauthdemo.component;

import com.de.publicpackage.result.CodeMsg;
import com.de.publicpackage.result.Result;
import com.de.securityoauthdemo.properties.SecurityProperties;
import com.de.securityoauthdemo.securityenum.SecurityEnum;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CustomAuthenticationFailureHandler
 *
 * @author 刘明浩
 * @Description  认证失败处理
 * @since 2020/12/26 9:23
 */
@Component("customAuthenticationFailureHandler")
//public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    SecurityProperties  securityProperties;

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            AuthenticationException e) throws IOException, ServletException {
        if(SecurityEnum.REDIRECT.equals(securityProperties.getAuthentication().getLoginHandlerType())){
            //回到登陆页面
            //super.setDefaultFailureUrl(securityProperties.getAuthentication().getLoginPage() + "?error");
            //回到上一页面
            String referer = httpServletRequest.getHeader("Referer");
            //String lastUrl = StringUtils.substringBefore(referer,"?");

            // 如果toAuthentication有值,则认为是多端登录,不管在哪个请求,直接回到登录页
            Object toAuthentication = httpServletRequest.getAttribute("toAuthentication");
            String lastUrl =
                    toAuthentication != null
                            ? securityProperties.getAuthentication().getLoginPage()
                            : StringUtils.substringBefore(referer,"?");

            super.setDefaultFailureUrl(lastUrl + "?error");
            super.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
        }else{
            Result result = Result.error(new CodeMsg(-1,e.getMessage()));
            //返回类型
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(result.toString());
        }
    }
}
