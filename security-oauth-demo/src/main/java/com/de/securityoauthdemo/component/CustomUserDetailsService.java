package com.de.securityoauthdemo.component;

import com.de.publicpackage.result.Result;
import com.de.securityoauthdemo.feign.UserFeignClient;
import com.de.securityoauthdemo.module.user.vo.CldUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Action;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 自定义用户信息数据源:  UserDetailsService
 * 需要实现security：UserDetailsService
 * 重写loadUserByUsername
 */
@Component("customUserDetailService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String s) throws AuthenticationException {
        //根据前端输入的用户名，查库
        CldUser sdd = new CldUser();
        String pwd = "";
        sdd.setName(s);
        Result<List<CldUser>> listRes = userFeignClient.selectList(sdd);
        if(null == listRes.getData() || listRes.getData().size() == 0){
            throw new BadCredentialsException("用户不存在");
        }else{
            CldUser  userRes = listRes.getData().get(0);
            if(StringUtils.isEmpty(userRes.getPassword())){
                throw new BadCredentialsException("密码获取异常");
            }else {
                //密码加密
                pwd = passwordEncoder.encode(userRes.getPassword());
            }
        }
        //封装 SpringSecurity  需要的UserDetails 对象并返回
        UserDetails userDetails = new User(
                                    s,
                                    pwd,
                                    AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN"));
        return userDetails;
    }
}
