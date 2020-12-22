package com.de.backinterfaceserver.module.user.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * APP用户表
 * </p>
 *
 * @author LiuMinghao
 * @since 2020-12-21
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="User对象", description="APP用户表")
public class User {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID主键用户ID")
    private String id;

    @ApiModelProperty(value = "用户登陆手机号")
    private String mobile;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "用户昵称")
    private String nickname;

    @ApiModelProperty(value = "用户头像")
    private String headimg;

    @ApiModelProperty(value = "用户Email")
    private String email;

    @ApiModelProperty(value = "注册时间")
    private LocalDateTime registerTime;

    @ApiModelProperty(value = "用户状态（0锁定、1正常）")
    private String lockStatus;

    @ApiModelProperty(value = "删除标识（0正常、1删除）")
    private String delFlag;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "数据版本号（乐观锁）")
    private String version;

    @ApiModelProperty(value = "微信id")
    private String openid;

    @ApiModelProperty(value = "认证后上传状态 0:未上传，1 : 已上传")
    private String authenticationUpload;

    @ApiModelProperty(value = "认证上传结果")
    private String uploadMessage;

}
