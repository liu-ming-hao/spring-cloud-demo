package com.de.securityoauthdemo.module.user.vo;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author LiuMinghao
 * @since 2021-01-04
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="OauthClientDetails对象", description="")
public class OauthClientDetails implements Serializable{

    private static final long serialVersionUID = 1L;


    private String clientId;


    private String clientSecret;


    private String resourceIds;


    private String scope;


    private String authorizedGrantType;


    private String webServerRedirectUri;


    private String authorities;


    private String accessTokenValidity;


    private String refreshTokenValidity;


    private String autoapprove;

    public OauthClientDetails(){}


}
