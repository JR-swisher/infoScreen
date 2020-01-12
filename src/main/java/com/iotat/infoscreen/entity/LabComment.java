package com.iotat.infoscreen.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @Description 实验室留言板
 * @ClassName LabComment
 * @Author Jean
 * @date 2020.01.08 15:07
 */
@ApiModel(description = "实验室留言板")
public class LabComment {

    @ApiModelProperty("主键")
    private long commentId;
    @ApiModelProperty("评论时间")
    private Date commentTime;
    @ApiModelProperty("评论内容")
    private String content;
    @ApiModelProperty("评论者用户名")
    @Pattern(regexp = "^[A-Za-z0-9_]+$", message = "用户名不符合规则")
    private String userName;

    public long getCommentId() {
        return commentId;
    }

    private void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
