package com.de.securityoauthdemo.feign;


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

        };
    }
}
