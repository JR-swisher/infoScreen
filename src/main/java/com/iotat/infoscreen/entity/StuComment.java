package com.iotat.infoscreen.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description 个人留言板
 * @ClassName StuComment
 * @Author Jean
 * @date 2020.01.08 15:15
 */
@ApiModel(description = "个人留言板")
public class StuComment {

    @ApiModelProperty("主键")
    private long commentId;
    @ApiModelProperty("评论时间")
    private String commentTime;
    @ApiModelProperty("评论内容")
    private String content;
    @ApiModelProperty("评论者")
    private String sender;
    @ApiModelProperty("被评论者")
    private String receiver;

    public long getCommentId() {
        return commentId;
    }

    private void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
