package com.atguigu.service.impl;

import com.atguigu.feign.SpringDemo02Feign;
import com.atguigu.mapper.CommentMapper;
import com.atguigu.pojo.Comment;
import com.atguigu.service.CommentService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.ibatis.cache.impl.PerpetualCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * CommentServiceImpl
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/6/22 22:29
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    public int saveComment(Comment comment){
        int insert = commentMapper.insert(comment);
        //int i=1/0;
        return insert;
    }

    public List<Comment> selectComment(Comment comment){
        final List<Comment> commentList =
                commentMapper.selectList(new LambdaQueryWrapper<Comment>()
                        .likeRight(Comment::getCommentContent, comment.getCommentContent()));
        //int i=1/0;

        return commentList;
    }
    @Autowired
    private SpringDemo02Feign springDemo02Feign;

    @Override
    public String testFeign() {
        String demo02 = springDemo02Feign.demo02();
        Comment comment = new Comment();
        comment.setCommentContent("zhang");
        List<Comment> commentList =
                commentMapper.selectList(new LambdaQueryWrapper<Comment>()
                        .likeRight(Comment::getCommentContent, comment.getCommentContent()));
        StringBuilder stringBuilder = new StringBuilder();
        for (Comment comment1 : commentList) {
            stringBuilder.append(comment1.toString());
        }
        return demo02+stringBuilder.toString();
    }
}
