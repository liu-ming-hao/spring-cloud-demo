package com.de.consumerserverdemo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * UserFeignClient
 *
 * @author 刘明浩
 * @Description   feign跨服务调用
 * @since 2020/12/8 13:36
 */
@FeignClient(name="provider-service-demo")
public interface UserFeignClient {

    @RequestMapping(value="/provider/hi",method = RequestMethod.GET)
    String home(@RequestParam String name);
}
