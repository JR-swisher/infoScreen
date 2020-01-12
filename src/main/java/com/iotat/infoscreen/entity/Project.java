package com.iotat.infoscreen.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description 项目
 * @ClassName Project
 * @Author Jean
 * @date 2020.01.08 09:55
 */
@ApiModel(description = "项目")
public class Project {

    @ApiModelProperty("主键")
    private long projId;
    @ApiModelProperty("项目名")
    private String projName;
    @ApiModelProperty("项目描述")
    private String projDesc;

    public long getProjId() {
        return projId;
    }

    private void setProjId(long projId) {
        this.projId = projId;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getProjDesc() {
        return projDesc;
    }

    public void setProjDesc(String projDesc) {
        this.projDesc = projDesc;
    }
}
