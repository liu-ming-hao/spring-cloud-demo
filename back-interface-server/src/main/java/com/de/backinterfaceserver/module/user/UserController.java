package com.de.backinterfaceserver.module.user;


import com.de.backinterfaceserver.feign.UserFeignClient;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author 刘明浩
 * @Description  用户服务模块入口
 * @since 2020/12/8 10:28
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户服务")
public class UserController {
   /* @Autowired
    private HelloService helloService;
*/
    @Autowired
    UserFeignClient userFeignClient;

    /*@RequestMapping("/hi")
    public String home(@RequestParam String name){
        return helloService.hiService(name);
    }*/

    @RequestMapping("/hifeign")
    public String homeFeign(@RequestParam String name) {
        return  userFeignClient.home(name);
    }
}
