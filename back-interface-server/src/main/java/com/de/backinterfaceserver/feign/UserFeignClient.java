package com.de.backinterfaceserver.feign;

import com.de.backinterfaceserver.module.user.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * UserFeignClient
 *
 * @author 刘明浩
 * @Description   feign跨服务调用
 * @since 2020/12/8 13:36
 */
@FeignClient(name="user-service",fallbackFactory = UserFeignClientFallback.class)
public interface UserFeignClient {

    @GetMapping(value="/provider/hi")
    String home(@RequestParam String name);

    @PostMapping("/user/findList")
    List<User> findList(@RequestBody User reqModel);
}
