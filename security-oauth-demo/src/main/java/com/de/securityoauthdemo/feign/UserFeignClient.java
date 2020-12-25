package com.de.securityoauthdemo.feign;





import com.de.publicpackage.result.Result;
import com.de.securityoauthdemo.module.user.vo.CldUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PostMapping("/cldUser/selectList")
    public Result<List<CldUser>> selectList(@RequestBody CldUser reqModel);

}
