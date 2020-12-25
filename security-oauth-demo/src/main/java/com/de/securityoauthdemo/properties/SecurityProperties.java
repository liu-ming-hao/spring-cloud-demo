package com.de.securityoauthdemo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * SecurityProperties
 *
 * @author 刘明浩
 * @Description
 * @since 2020/12/25 15:09
 */
@Component
@ConfigurationProperties(prefix = "cis.security") //读取yml文件中对应属性下的值
public class SecurityProperties {
    /**
     * 文件中对应属性下的值,绑定到实体中
     * ********注意********
     * 该名称必须与yml中对应的名一致:authentication
     */
    private AuthenticationProperties authentication;

    public AuthenticationProperties getAuthentication() {
        return authentication;
    }

    public void setAuthentication(AuthenticationProperties authentication) {
        this.authentication = authentication;
    }
}
