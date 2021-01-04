package com.de.userserver.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author LiuMinghao
 * @since 2021-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("OAUTH_CLIENT_DETAILS")
@ApiModel(value="OauthClientDetails对象", description="")
public class OauthClientDetails extends Model<OauthClientDetails> {

    private static final long serialVersionUID = 1L;

    @TableId("CLIENT_ID")
    private String clientId;

    @TableField("CLIENT_SECRET")
    private String clientSecret;

    @TableField("RESOURCE_IDS")
    private String resourceIds;

    @TableField("SCOPE")
    private String scope;

    @TableField("AUTHORIZED_GRANT_TYPE")
    private String authorizedGrantType;

    @TableField("WEB_SERVER_REDIRECT_URI")
    private String webServerRedirectUri;

    @TableField("AUTHORITIES")
    private String authorities;

    @TableField("ACCESS_TOKEN_VALIDITY")
    private String accessTokenValidity;

    @TableField("REFRESH_TOKEN_VALIDITY")
    private String refreshTokenValidity;

    @TableField("AUTOAPPROVE")
    private String autoapprove;


    @Override
    protected Serializable pkVal() {
        return this.clientId;
    }

}
