package com.de.securityoauthdemo.module.user.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author LiuMinghao
 * @since 2020-12-25
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CldUser对象", description="")
public class CldUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "账户是否过期 0 未过期、1 已过期")
    private String isAccountNonExpired;

    @ApiModelProperty(value = "是否被锁定 0 未锁定、1 已锁定")
    private String isAccountNonLock;

    @ApiModelProperty(value = "密码是否过期 0 未过期、1 已过期")
    private String isCredentialsNonExpired;

    @ApiModelProperty(value = "账户是否可用 0 可用，1 不可用")
    private String isEnabled;

    @ApiModelProperty(value = "是否删除 0 未删除、1 已删除")
    private String isDelete;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    public CldUser() {

    }
}
