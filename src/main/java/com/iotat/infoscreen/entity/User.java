package com.iotat.infoscreen.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;

/**
 * @Description 帐号
 * @ClassName User
 * @Author Jean
 * @date 2020.01.07 17:18
 */
@ApiModel(description = "帐号信息")
public class User {

    @ApiModelProperty("主键")
    private long userId;
    @ApiModelProperty("用户名")
    @Pattern(regexp = "^\\w{6,20}$", message = "用户名不符合规则")
    private String userName;
    @ApiModelProperty("密码")
    @Pattern(regexp = "^\\w{6,20}$", message = "密码不符合规则")
    private String password;
    @ApiModelProperty("头像url")
    private String avatar;
    @ApiModelProperty("个性签名")
    private Byte signature;
    @ApiModelProperty("用户权限")
    private Boolean authority;

    public long getUserId() {
        return userId;
    }

    private void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Byte getSignature() {
        return signature;
    }

    public void setSignature(Byte signature) {
        this.signature = signature;
    }

    public Boolean getAuthority() {
        return authority;
    }

    public void setAuthority(Boolean authority) {
        this.authority = authority;
    }
}
