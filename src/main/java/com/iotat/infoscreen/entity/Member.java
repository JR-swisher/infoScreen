package com.iotat.infoscreen.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;

/**
 * @Description 成员信息
 * @ClassName Member
 * @Author Jean
 * @date 2020.01.08 09:57
 */
@ApiModel(description = "成员信息")
public class Member {

    @ApiModelProperty("主键")
    private long memberId;
    @ApiModelProperty("学号")
    @Pattern(regexp = "^[0-9]{10}$", message = "学号不符合规则")
    private String stuId;
    @ApiModelProperty("真实姓名")
    private String realName;
    @ApiModelProperty("性别")
    private Boolean gender;
    @ApiModelProperty("专业")
    private String major;
    @ApiModelProperty("班级")
    private String className;
    @ApiModelProperty("个人介绍")
    private String intro;
    @ApiModelProperty("技术栈")
    private String techStack;
    @ApiModelProperty("Git网址")
    private String gitSite;
    @ApiModelProperty("QQ号")
    private String QQ;
    @ApiModelProperty("用户名")
    @Pattern(regexp = "^\\w{6,20}$", message = "用户名不符合规则")
    private String userName;

    public long getMemberId() {
        return memberId;
    }

    private void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public String getGitSite() {
        return gitSite;
    }

    public void setGitSite(String gitSite) {
        this.gitSite = gitSite;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
