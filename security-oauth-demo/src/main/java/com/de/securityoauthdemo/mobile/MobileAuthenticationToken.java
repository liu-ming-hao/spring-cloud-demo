package com.de.securityoauthdemo.mobile;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 封装手机认证信息
 */
public class MobileAuthenticationToken extends AbstractAuthenticationToken {
    private static final long serialVersionUID = 520L;
    // principal:认证前存的是手机号码,认证后存的是用户信息
    private final Object principal;

    /**
     * 认证之前使用的构造方法, 此方法会标识未认证
     *
     */
    public MobileAuthenticationToken(Object principal) {
        super((Collection)null);
        this.principal = principal; // 手机号码
        setAuthenticated(false); // 未认证
    }

    /**
     * 认证通过后,会重新创建MobileAuthenticationToken实例 ,来进行封装认证信息
     * @param principal 用户信息
     * @param authorities 权限资源
     */
    public MobileAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;//用户信息
        super.setAuthenticated(true); // 已认证
    }


    /**
     * 因为它是父类中的抽象方法,,所以要实现,这里是返回密码,没有密码,直接返回null即可
     * @return
     */
    @Override
    public Object getCredentials() {
        return null;
    }

    //获取用户信息,这里是返回用户信息
    public Object getPrincipal() {
        return this.principal;
    }

    //设置权限资源
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        } else {
            super.setAuthenticated(false);
        }
    }

    public void eraseCredentials() {
        super.eraseCredentials();
    }

}
