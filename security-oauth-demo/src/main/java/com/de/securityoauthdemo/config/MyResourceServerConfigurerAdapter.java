package com.de.securityoauthdemo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * MyResourceServerConfigurerAdapter
 *
 * @author 刘明浩
 * @Description  资源服务
 * @since 2020/12/30 14:37
 */
@Configuration
@EnableResourceServer //声明资源服务
public class MyResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {

}
