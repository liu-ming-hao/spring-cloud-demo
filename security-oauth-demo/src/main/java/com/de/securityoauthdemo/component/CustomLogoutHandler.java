package com.de.securityoauthdemo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CustomLogoutHandler
 *
 * @author 刘明浩
 * @Description  退出登录处理
 * @since 2020/12/28 14:25
 */
@Component
public class CustomLogoutHandler implements LogoutHandler {
    @Autowired
    private SessionRegistry sessionRegistry;

    @Override
    public void logout(
            HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse
            , Authentication authentication) {
        //退出登录后，将对应session从缓存中清除 SessionRegistryImpl.principals
        sessionRegistry.removeSessionInformation(httpServletRequest.getSession().getId());
    }
}
