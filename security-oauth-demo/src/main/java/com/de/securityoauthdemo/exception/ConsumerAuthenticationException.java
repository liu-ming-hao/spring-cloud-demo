package com.de.securityoauthdemo.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * ValidateCodeException
 *
 * @author 刘明浩
 * @Description 异常类
 * @since 2020/12/26 14:08
 */
public class ConsumerAuthenticationException extends AuthenticationException {
    public ConsumerAuthenticationException(String msg,Throwable t){
        super(msg,t);
    }

    public ConsumerAuthenticationException(String msg){
        super(msg);
    }
}
