package com.de.securityoauthdemo.feign;


import com.de.publicpackage.result.CodeMsg;
import com.de.publicpackage.result.Result;
import com.de.securityoauthdemo.module.user.vo.CldUser;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * UserFeignClientFailBack
 *
 * @author 刘明浩
 * @Description
 * @since 2020/12/21 10:52
 */
@Component
@Slf4j
public class UserFeignClientFallback implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {

            @Override
            public Result<List<CldUser>> selectList(CldUser reqModel) {
                return Result.error(new CodeMsg(-111,"fallback"));
            }
        };
    }
}
