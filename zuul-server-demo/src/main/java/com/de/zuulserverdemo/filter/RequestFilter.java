package com.de.zuulserverdemo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

/**
 * RequestFilter
 *
 * @author 刘明浩
 * @Description  过滤器   拦截请求  做权限校验
 * @since 2020/12/8 16:37
 */
@Component
@Slf4j  //使用 lonbok 实现日志输出
public class RequestFilter extends ZuulFilter {


    //四种类型：pre,routing,error,post
    //pre：主要用在路由映射的阶段是寻找路由映射表的
    //routing:具体的路由转发过滤器是在routing路由器，具体的请求转发的时候会调用
    //error:一旦前面的过滤器出错了，会调用error过滤器。
    //post:当routing，error运行完后才会调用该过滤器，是在最后阶段的
    @Override
    public String filterType() {
        return "pre";
    }

    //自定义过滤器执行的顺序，数值越大越靠后执行，越小就越先执行
    @Override
    public int filterOrder() {
        return 1;
    }

    //控制过滤器生效不生效，可以在里面写一串逻辑来控制
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //执行过滤逻辑
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String url = request.getRequestURL().toString();
        log.info("zuul filter get request: " + url);
        if(null == request.getParameter("name")){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.setResponseBody("zuul filter checked: there is no request parameter name!!!!!");
            return null;
        }
        return null;
    }
}
