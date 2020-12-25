package com.de.securityoauthdemo.config;

import com.de.securityoauthdemo.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SpringSecurityConfig
 *
 * @author 刘明浩
 * @Description  安全控制配置类
 * 安全控制中心:
 *  1.身份认证
 *  2.授权
 * @since 2020/12/25 9:42
 */
//EnableWebSecurity 启动web安全，两个作用：
//                  1.加载了WebSecurityConfiguration配置类，配置安全认证策略
//                  2.加载了AuthenticationConfiguration,，配置了认证信息
@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    //yml获取配置信息
    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 密码加密
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        //使用BCryptPasswordEncoder()进行加密
        // 明文+随机盐值》加密存储
        //常用方法:
        //      encode:用于加密明文
        //      matches:前端输入的密码与数据库中的密码对比
        //      upgradeEncoding:是否需要重新编码，一般不需要
        return new BCryptPasswordEncoder();
    }

    /**
     *  AuthenticationManagerBuilder  身份认证管理器
     *  1.认证信息提供方式（用户名、密码、当前用户的资源权限）
     *  2.认证方式： redis、数据库
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        //配置用户名密码
        /**
         * 配置认证用户的数据源
         * 1.默认
         * 2.内存
         * 3.数据库
         */
        //默认SpringSecurity生成
        //super.configure(auth);
        //内存
        auth.inMemoryAuthentication()
                .withUser("neicun")
                .password(passwordEncoder().encode("neicun"))//密码加密。否则报错
                .authorities("ADMIN")//授权
        ;
        //数据库

    }

    /**
     * HttpSeccurity 资源权限配置（过滤器链）
     *      1.拦截资源，资源对应的角色
     *      2.定义认证方式: httpBasic、httpForm
     *      3.定义登录页面、登录请求地址、登录成功处理、登录错误处理
     *      4.自定义 spring security过滤器链
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.httpBasic() //采用httpBasic认证方式（弹窗）
        http.formLogin()//表单认证  页面形式
                .loginPage(securityProperties.getAuthentication().getLoginPage())//自定义登录页面
                .loginProcessingUrl(securityProperties.getAuthentication().getLoginProcessingUrl())//登录表单提交处理url,默认是/login
                .usernameParameter(securityProperties.getAuthentication().getUsernameParameter()) //定义登录表单 用户名属性名称
                .passwordParameter(securityProperties.getAuthentication().getPasswordParameter()) //定义登录表单 密码
                .defaultSuccessUrl(securityProperties.getAuthentication().getDefaultSuccessUrl()) //登录成功处理
                .and()
                .authorizeRequests() //认证请求
                .antMatchers(securityProperties.getAuthentication().getApiAntMatchers()).permitAll() //免认证
                .anyRequest().authenticated() //所有进入应用的Http请求都需要认证
        ;
        //默认都会产生一个hiden标签 里面有安全相关的验证 防止请求伪造 这边我们暂时不需要 可禁用掉
        http .csrf().disable();
    }

    /**
     * 静态资源处理
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
