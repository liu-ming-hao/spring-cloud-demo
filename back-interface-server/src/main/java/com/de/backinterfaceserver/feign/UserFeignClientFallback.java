package com.de.backinterfaceserver.feign;

import com.de.backinterfaceserver.module.user.model.User;
import com.de.publicpackage.page.PageRes;
import com.de.publicpackage.result.CodeMsg;
import com.de.publicpackage.result.Result;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
            public String home(String name) {
                log.info("User-Feign fallback: " + throwable);
                return "User-Feign fallback:" + throwable;
            }

            @Override
            public Result<List<User>> selectList(User reqModel) {
                log.info("User-Feign fallback: " + throwable);
                return Result.error(new CodeMsg(-101,"user-feign fallback:" + throwable));
            }

            @Override
            public Result<PageRes> selectPage(User reqModel) {
                log.info("User-Feign fallback: " + throwable);
                return Result.error(new CodeMsg(-102,"user-feign fallback:" + throwable));
            }
        };
    }
}
