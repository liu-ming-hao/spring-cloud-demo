package com.de.securityoauthdemo.session;

import com.de.publicpackage.result.CodeMsg;
import com.de.publicpackage.result.Result;
import org.springframework.security.web.session.InvalidSessionStrategy;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CustomInvalidSessionStrategy
 *
 * @author 刘明浩
 * @Description 当session失效后的处理逻辑
 * @since 2020/12/28 8:23
 */
public class CustomInvalidSessionStrategy  implements InvalidSessionStrategy {

    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 要将浏览器中的cookie的jsessionid删除
        cancelCookie(request, response);

        Result result = Result.error(new CodeMsg( -2, "登录已超时，请重新登录"));

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(result.toString());
    }

    protected void cancelCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setMaxAge(0);
        cookie.setPath(getCookiePath(request));
        response.addCookie(cookie);
    }

    private String getCookiePath(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        return contextPath.length() > 0 ? contextPath : "/";
    }
}
