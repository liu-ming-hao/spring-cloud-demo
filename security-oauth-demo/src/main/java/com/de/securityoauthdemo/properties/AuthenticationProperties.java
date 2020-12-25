package com.de.securityoauthdemo.properties;

import lombok.Data;

/**
 * AuthenticationProperties
 *
 * @author 刘明浩
 * @Description  配置
 * @since 2020/12/25 15:23
 */
@Data
public class AuthenticationProperties {
    private String loginPage;
    private String loginProcessingUrl;
    private String usernameParameter;
    private String passwordParameter;
    private String defaultSuccessUrl;
    private String[] apiAntMatchers;
}
