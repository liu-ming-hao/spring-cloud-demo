package com.de.securityoauthdemo.component;

import com.de.publicpackage.result.Result;
import com.de.securityoauthdemo.feign.UserFeignClient;
import com.de.securityoauthdemo.module.user.vo.OauthClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * CustomClientDetailService
 *
 * @author 刘明浩
 * @Description  客户端  数据源逻辑
 * @since 2021/1/4 13:55
 */
@Component("customClientDetailService")
public class CustomClientDetailService implements ClientDetailsService {
    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        OauthClientDetails oauthClientDetails = new OauthClientDetails();
        oauthClientDetails.setClientId(s);
        Result<List<OauthClientDetails>> listResult = userFeignClient.selectList(oauthClientDetails);
        if(null != listResult.getData() && listResult.getData().size() > 0){
            ClientDetails clientDetails = (ClientDetails) listResult.getData().get(0);
            return clientDetails;
        }else {
            throw new ClientRegistrationException("未注册的客户端，没有访问权限");
        }
    }
}
