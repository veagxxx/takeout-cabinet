package com.zhy.takeoutcabinet.entity;

import java.util.Date;

public class Comment {

    private Integer commentId;
    private String commentUsername;
    private Integer star;
    private String content;
    private Date createTime;
    private Cabinet cabinet;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentUsername() {
        return commentUsername;
    }

    public void setCommentUsername(String commentUsername) {
        this.commentUsername = commentUsername;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentUsername='" + commentUsername + '\'' +
                ", star=" + star +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", cabinet=" + cabinet +
                '}';
    }
}
