package com.de.securityoauthdemo.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * JdbcTokenStore
 *
 * @author 刘明浩
 * @Description token存储：数据库
 * @since 2021/1/4 10:18
 */
public class DbTokenStore {
    @Autowired
    private DataSource dataSource;

    @Bean
    public TokenStore tokenStore(){
        return new JdbcTokenStore(dataSource);
    }
}
