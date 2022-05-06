package com.zhy.takeoutcabinet.service;

import com.zhy.takeoutcabinet.entity.Comment;

public interface CommentService {

    /**
     * 添加评价
     * @param comment 评价信息
     * @return 1
     */
    int evaluateOrder(Comment comment);
}
