package com.iotat.infoscreen.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @Description 成员获奖信息
 * @ClassName Award
 * @Author Jean
 * @date 2020.01.07 16:51
 */
@ApiModel(description = "成员获奖信息")
public class Award {

    @ApiModelProperty("主键")
    private long awardId;
    @ApiModelProperty("获奖名")
    private String awardName;
    @ApiModelProperty("获奖时间")
    private Date awardTime;
    @ApiModelProperty("竞赛等级(国家级、省级等)")
    private String contestLevel;
    @ApiModelProperty("获奖等级(一等、二等...)")
    private String awardLevel;
    @ApiModelProperty("学号")
    @Pattern(regexp = "^[0-9]{10}$", message = "学号不符合规则")
    private String stuId;

    public long getAwardId() {
        return awardId;
    }

    private void setAwardId(long awardId) {
        this.awardId = awardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public Date getAwardTime() {
        return awardTime;
    }

    public void setAwardTime(Date awardTime) {
        this.awardTime = awardTime;
    }

    public String getContestLevel() {
        return contestLevel;
    }

    public void setContestLevel(String contestLevel) {
        this.contestLevel = contestLevel;
    }

    public String getAwardLevel() {
        return awardLevel;
    }

    public void setAwardLevel(String awardLevel) {
        this.awardLevel = awardLevel;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }
}
