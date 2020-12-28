package com.de.securityoauthdemo.session;

import com.de.securityoauthdemo.component.CustomAuthenticationFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * CustomSessionInformationExpiredStrategy
 *
 * @author 刘明浩
 * @Description  同一用户在系统中  Session 过量处理
 * @since 2020/12/28 9:40
 */
public class CustomSessionInformationExpiredStrategy implements SessionInformationExpiredStrategy {
    @Autowired
    CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
        //获取用户名
        UserDetails userDetails = (UserDetails) sessionInformationExpiredEvent.getSessionInformation().getPrincipal();
        //构建提示信息
        AuthenticationException exception = new AuthenticationServiceException(
                String.format("用户 [%s] 在另一台设备登录，您已被下线",userDetails.getUsername()));

        //用户在另一台设备上登录， 由失败处理器 跳回登录页面
        sessionInformationExpiredEvent.getRequest().setAttribute("toAuthentication",true);
        customAuthenticationFailureHandler.onAuthenticationFailure(
                                                            sessionInformationExpiredEvent.getRequest()
                                                            ,sessionInformationExpiredEvent.getResponse()
                                                            ,exception);
    }
}
