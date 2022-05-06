package com.zhy.takeoutcabinet.mapper;

import com.zhy.takeoutcabinet.entity.Comment;

import java.util.List;

public interface CommentMapper {
    /**
     * 查询所有评价
     * @return list
     */
    List<Comment> queryAll();

    /**
     * 添加评价
     * @param comment 评价信息
     * @return 1
     */
    int insertComment(Comment comment);
}
