package com.zhy.takeoutcabinet.service.impl;

import com.zhy.takeoutcabinet.entity.Comment;
import com.zhy.takeoutcabinet.mapper.CommentMapper;
import com.zhy.takeoutcabinet.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Resource
    CommentMapper commentMapper;

    @Override
    public int evaluateOrder(Comment comment) {
        return commentMapper.insertComment(comment);
    }
}
