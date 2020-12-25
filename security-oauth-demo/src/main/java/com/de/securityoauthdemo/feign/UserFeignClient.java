package com.de.securityoauthdemo.feign;




import org.springframework.cloud.openfeign.FeignClient;

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


}
