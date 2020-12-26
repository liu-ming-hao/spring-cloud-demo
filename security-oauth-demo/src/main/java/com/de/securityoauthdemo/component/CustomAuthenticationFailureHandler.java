package com.de.securityoauthdemo.component;

import com.de.publicpackage.result.CodeMsg;
import com.de.publicpackage.result.Result;
import com.de.securityoauthdemo.properties.SecurityProperties;
import com.de.securityoauthdemo.securityenum.SecurityEnum;
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
            super.setDefaultFailureUrl(securityProperties.getAuthentication().getLoginPage() + "?error");
            super.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
        }else{
            Result result = Result.error(new CodeMsg(-1,e.getMessage()));
            //返回类型
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(result.toString());
        }
    }
}
