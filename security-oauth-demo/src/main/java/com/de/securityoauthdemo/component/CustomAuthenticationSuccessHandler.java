package com.de.securityoauthdemo.component;

import com.de.publicpackage.result.Result;
import com.de.securityoauthdemo.properties.SecurityProperties;
import com.de.securityoauthdemo.securityenum.SecurityEnum;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CustomAuthenticationSuccessHandler
 *
 * @author 刘明浩
 * @Description  认证成功处理
 * @since 2020/12/26 9:04
 */
@Component("customAuthenticationSuccessHandler")
//public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Authentication authentication) throws IOException, ServletException {
        if(SecurityEnum.REDIRECT.equals(securityProperties.getAuthentication().getLoginHandlerType())){
            //重定向到触发认证的请求地址
            /*RequestCache cache = new HttpSessionRequestCache();
            SavedRequest savedRequest = cache.getRequest(httpServletRequest, httpServletResponse);
            // 如果来源请求为空则跳转到用户博客首页
            String url = "";
            if((savedRequest==null)){
                //url = "/blog/"+ SecurityUtil.getLoginUser();
            }else{
                url = savedRequest.getRedirectUrl();
            }

            System.out.println(url);

            httpServletResponse.sendRedirect(url);*/
            super.onAuthenticationSuccess(httpServletRequest,httpServletResponse,authentication);
        }else{
            // 认证成功后，告诉前端,返回响应JSON字符串
            Result result = Result.success("登录认证成功！");
            //返回类型
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            //把数据转成字符串类型
            String value = result.toString();
            //信息写在页面中
            httpServletResponse.getWriter().write(value);
        }
    }
}
