package com.de.consumerserverdemo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * UserFeignClient
 *
 * @author 刘明浩
 * @Description   feign跨服务调用
 * @since 2020/12/8 13:36
 */
@FeignClient(name="provider-service-demo",fallbackFactory = UserFeignClientFallback.class)
public interface UserFeignClient {

    @GetMapping(value="/provider/hi")
    String home(@RequestParam String name);
}
