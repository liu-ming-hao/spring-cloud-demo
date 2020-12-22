package com.de.backinterfaceserver.controller.configrefresh;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConfigRefreshController
 *
 * @author 刘明浩
 * @Description  从 配置中心  拉取 公共配置
 * @since 2020/12/10 16:11
 */
@RestController
@RefreshScope //开启更新功能
public class ConfigRefreshController {
    @Value("${nickName}")
    private String nickName;

    @RequestMapping("/hello")
    public String from() {
        return "Hello----------->\t" +this.nickName;
    }
}
