package com.de.backinterfaceserver.module.user.web;


import com.de.backinterfaceserver.feign.UserFeignClient;
import com.de.backinterfaceserver.module.user.model.User;
import com.de.backinterfaceserver.service.HelloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Autowired
    private HelloService helloService;
    @Autowired
    UserFeignClient userFeignClient;

    /*@RequestMapping("/hi")
    public String home(@RequestParam String name){
        return helloService.hiService(name);
    }*/

    @GetMapping("/hifeign")
    public String homeFeign(@RequestParam String name) {
        return  helloService.hiServiceFeign(name);
    }

    @ApiOperation("查询用户列表")
    @PostMapping("findList")
    public List<User> findList(@RequestBody User reqModel){return userFeignClient.findList(reqModel);}
}
