package com.de.securityoauthdemo.config;

import com.de.securityoauthdemo.component.MobileAuthenticationConfig;
import com.de.securityoauthdemo.filter.ImageCodeValidateFilter;
import com.de.securityoauthdemo.filter.MobileValidateFilter;
import com.de.securityoauthdemo.mobile.MobileAuthenticationFilter;
import com.de.securityoauthdemo.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.sql.DataSource;


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
    //自定义认证用户数据源
    @Autowired
    private UserDetailsService customUserDetailService;
    //自定义认证成功处理
    @Autowired
    private AuthenticationSuccessHandler customAuthenticationSuccessHandler;
    //自定义认证失败处理
    @Autowired
    private AuthenticationFailureHandler customAuthenticationFailureHandler;
    //过滤器 图形验证码
    @Autowired
    private ImageCodeValidateFilter imageCodeValidateFilter;
    //过滤器 手机认证
    @Autowired
    private MobileValidateFilter mobileValidateFilter;
    //手机号验证组合
    @Autowired
    private MobileAuthenticationConfig mobileAuthenticationConfig;
    //session失效后的处理
    @Autowired
    private InvalidSessionStrategy invalidSessionStrategy;
    //同一用户  多设备登录（session过量） 处理
    @Autowired
    SessionInformationExpiredStrategy sessionInformationExpiredStrategy;
    //退出登录处理
    @Autowired
    private LogoutHandler customLogoutHandler;

    @Autowired
    DataSource dataSource;


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
        /*auth.inMemoryAuthentication()
                .withUser("neicun")
                .password(passwordEncoder().encode("neicun"))//密码加密。否则报错
                .authorities("ADMIN")//授权
        ;*/
        //数据库
        auth.userDetailsService(customUserDetailService);

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
        /**
         * .addFilterBefore（A,B）
         * 请求前过滤，如果 A 通过验证，则进入 B 验证。
         */
        //http.httpBasic() //采用httpBasic认证方式（弹窗）
        http.addFilterBefore(mobileValidateFilter, UsernamePasswordAuthenticationFilter.class) //手机验证码登陆：过滤 手机号
                .addFilterBefore(imageCodeValidateFilter, UsernamePasswordAuthenticationFilter.class) //用户名密码登陆：过滤 验证码
                .formLogin()//表单认证  页面形式
                .loginPage(securityProperties.getAuthentication().getLoginPage())//自定义登录页面
                .loginProcessingUrl(securityProperties.getAuthentication().getLoginProcessingUrl())//登录表单提交处理url,默认是/login
                .usernameParameter(securityProperties.getAuthentication().getUsernameParameter()) //定义登录表单 用户名属性名称
                .passwordParameter(securityProperties.getAuthentication().getPasswordParameter()) //定义登录表单 密码
                .successHandler(customAuthenticationSuccessHandler) //认证成功处理
                .failureHandler(customAuthenticationFailureHandler) //认证失败处理
                .and()
                .authorizeRequests() //认证请求
                .antMatchers(securityProperties.getAuthentication().getApiAntMatchers()).permitAll() //免认证
                .anyRequest().authenticated() //所有进入应用的Http请求都需要认证
                .and()
                .rememberMe()//配置记住我功能
                .tokenRepository(jdbcTokenRepository()) //保存登录信息
                .tokenValiditySeconds(60*60*24)//记住我有效时长
                .and()
                .sessionManagement()//session 管理
                .invalidSessionStrategy(invalidSessionStrategy) //session失效后的处理
                .maximumSessions(1) //每个用户在系统中只能有一个session
                .expiredSessionStrategy(sessionInformationExpiredStrategy) //用户多设备登录---退出前面的用户
                .maxSessionsPreventsLogin(true) //用户多设备登录---不允许后面的设备登录  该配置优先级大于上面的 优先级
                .sessionRegistry(sessionRegistry())
                .and().and()
                .logout() //退出登录
                .addLogoutHandler(customLogoutHandler)
        ;
        //默认都会产生一个hiden标签 里面有安全相关的验证 防止请求伪造 这边我们暂时不需要 可禁用掉
        http .csrf().disable();
        //将手机配置组合添加到过滤器链上
        http.apply(mobileAuthenticationConfig);
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

    /**
     * 记住我功能（security  remenber-me）
     * 1.用户选择‘记住我’成功登录后，将username+序列号+token 存入数据库表中
     *       ，同时将三者组成cookie 发送给客户端浏览器
     * 2.当未登录的客户访问系统，首先检查remember-me的cookie值
     *        ，有则检查其username+序列号+token与数据库中对比，一致则通过认证
     *        ，同时 系统生成一个新的token，替换数据库中的旧token。序列号series保持不变
     *              ，并 删除旧的cookie。生成新的cookie（新token + 旧序列号 + username）发送客户端
     * 3.如果对应cookie不存在、或者username\序列号和token 与数据库中保存的不一致
     *          ,将引导用户进入登录页面
     *  *******  cookie被盗用的情况，用户下次登录前该cookie存在安全漏洞。系统安全性要求高的场景不适合
     * @return JdbcTokenRepositoryImpl
     */
    @Bean
    public JdbcTokenRepositoryImpl jdbcTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        // 是否启动项目时自动创建表，true自动创建  第一次启动后 注释掉
        //jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    /**
     * 解决退出之后，登录 提示最大登录数
     */
    @Bean
    public SessionRegistry sessionRegistry(){
        return  new SessionRegistryImpl();
    }
}
