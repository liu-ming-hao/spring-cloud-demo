package com.de.securityoauthdemo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * MyAuthorizationServerConfigurerAdapter
 *
 * @author 刘明浩
 * @Description  授权服务器配置
 * @since 2020/12/30 12:58
 */
@Configuration
@EnableAuthorizationServer  //声明授权服务
public class MyAuthorizationServerConfigurerAdapter extends AuthorizationServerConfigurerAdapter {

}
