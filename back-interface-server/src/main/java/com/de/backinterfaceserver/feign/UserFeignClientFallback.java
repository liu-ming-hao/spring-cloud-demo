package com.de.backinterfaceserver.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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
            public String home(String name) {
                log.info("User-Feign fallback: " + throwable);
                return "User-Feign fallback:" + throwable;
            }
        };
    }
}
