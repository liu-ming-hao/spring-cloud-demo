package com.de.securityoauthdemo.annotation;

import com.de.securityoauthdemo.store.DbTokenStore;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: liu-minghao
 * @date: 2021/1/4
 * @description: 在启动类上添加该注解来----开启通过数据库存储令牌
 *               数据库 schema ：https://github.com/spring-projects/spring-security-oauth/blob/master/spring-security-oauth2/src/test/resources/schema.sql
 */
@Target(ElementType.TYPE) //注解的作用目标 接口、类、枚举、注解
@Retention(RetentionPolicy.RUNTIME) //注解的生命周期
@Import(DbTokenStore.class)
public @interface EnableDbTokenStore {
}
