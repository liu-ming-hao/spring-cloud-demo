package com.de.userserver.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("CLD_USER")
@ApiModel(value="CldUser对象", description="")
public class CldUser extends Model<CldUser> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId("ID")
    private String id;

    @ApiModelProperty(value = "用户名")
    @TableField("NAME")
    private String name;

    @ApiModelProperty(value = "密码")
    @TableField("PASSWORD")
    private String password;

    @ApiModelProperty(value = "账户是否过期 0 未过期、1 已过期")
    @TableField("IS_ACCOUNT_NON_EXPIRED")
    private String isAccountNonExpired;

    @ApiModelProperty(value = "是否被锁定 0 未锁定、1 已锁定")
    @TableField("IS_ACCOUNT_NON_LOCK")
    private String isAccountNonLock;

    @ApiModelProperty(value = "密码是否过期 0 未过期、1 已过期")
    @TableField("IS_CREDENTIALS_NON_EXPIRED")
    private String isCredentialsNonExpired;

    @ApiModelProperty(value = "账户是否可用 0 可用，1 不可用")
    @TableField("IS_ENABLED")
    private String isEnabled;

    @ApiModelProperty(value = "是否删除 0 未删除、1 已删除")
    @TableField("IS_DELETE")
    private String isDelete;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
