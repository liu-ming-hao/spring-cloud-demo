package com.de.backinterfaceserver.feign;


import com.de.backinterfaceserver.module.user.model.User;
import com.de.publicpackage.page.PageRes;
import com.de.publicpackage.result.Result;
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

    @PostMapping("/user/selectList")
    Result<List<User>> selectList(@RequestBody User reqModel);

    @PostMapping("/user/selectPage")
    public Result<PageRes>  selectPage(@RequestBody User reqModel);
}
