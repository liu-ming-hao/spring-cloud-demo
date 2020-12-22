package com.de.userserver.model;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * APP用户表
 * </p>
 *
 * @author LiuMinghao
 * @since 2020-12-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("A_USER")
@ApiModel(value="User对象", description="APP用户表")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID主键用户ID")
    @TableField("ID")
    private String id;

    @ApiModelProperty(value = "用户登陆手机号")
    @TableField("MOBILE")
    private String mobile;

    @ApiModelProperty(value = "登录密码")
    @TableField("PASSWORD")
    private String password;

    @ApiModelProperty(value = "用户昵称")
    @TableField("NICKNAME")
    private String nickname;

    @ApiModelProperty(value = "用户头像")
    @TableField("HEADIMG")
    private String headimg;

    @ApiModelProperty(value = "用户Email")
    @TableField("EMAIL")
    private String email;

    @ApiModelProperty(value = "注册时间")
    @TableField("REGISTER_TIME")
    private LocalDateTime registerTime;

    @ApiModelProperty(value = "用户状态（0锁定、1正常）")
    @TableField("LOCK_STATUS")
    private String lockStatus;

    @ApiModelProperty(value = "删除标识（0正常、1删除）")
    @TableField("DEL_FLAG")
    private String delFlag;

    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "数据版本号（乐观锁）")
    @TableField("VERSION")
    private String version;

    @ApiModelProperty(value = "微信id")
    @TableField("OPENID")
    private String openid;

    @ApiModelProperty(value = "认证后上传状态 0:未上传，1 : 已上传")
    @TableField("AUTHENTICATION_UPLOAD")
    private String authenticationUpload;

    @ApiModelProperty(value = "认证上传结果")
    @TableField("UPLOAD_MESSAGE")
    private String uploadMessage;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
