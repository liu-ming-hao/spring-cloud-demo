package com.de.securityoauthdemo.config;


import com.de.securityoauthdemo.mobile.SmsCodeSender;
import com.de.securityoauthdemo.mobile.SmsSend;
import com.de.securityoauthdemo.session.CustomInvalidSessionStrategy;
import com.de.securityoauthdemo.session.CustomSessionInformationExpiredStrategy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * 主要为容器中添加Bean实例
 */
@Configuration
public class SecurityConfigBean {

    /**
     * @ConditionalOnMissingBean(SmsSend.class)
     * 默认情况下，采用的是SmsCodeSender实例 ，
     * 但是如果容器当中有其他的SmsSend类型的实例，
     * 那当前的这个SmsCodeSender就失效 了
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(SmsSend.class)
    public SmsSend smsSend() {

        return new SmsCodeSender();

    }

    /**
     * session 失效后的处理类
     */
    @Bean
    @ConditionalOnMissingBean(InvalidSessionStrategy.class) //声明 该类型的bean 只能有一个实现
    public InvalidSessionStrategy invalidSessionStrategy(){
        return new CustomInvalidSessionStrategy();
    }

    /**
     * CustomSessionInformationExpiredStrategy 加入容器  用户多设备登录处理
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
    public SessionInformationExpiredStrategy sessionInformationExpiredStrategy(){
        return new CustomSessionInformationExpiredStrategy();
    }
}
