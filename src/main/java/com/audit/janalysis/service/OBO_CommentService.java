package com.audit.janalysis.service;

import com.audit.janalysis.entity.OBO_Comment;
import com.audit.janalysis.mapper.OBO_CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OBO_CommentService {

        @Autowired
        private OBO_CommentMapper oboCommentMapper;

        public int insert(OBO_Comment oboComment) {
            // 插入评论
            return oboCommentMapper.insert(oboComment);
        }

        public int delete(OBO_Comment oboComment) {
            // 删除评论
            return oboCommentMapper.deleteById(oboComment);
        }

        public int update(OBO_Comment oboComment) {
            // 更新评论
            return oboCommentMapper.updateById(oboComment);
        }

        public OBO_Comment getCommentById(int commentId) {
            return oboCommentMapper.selectById(commentId);
        }

        public List<OBO_Comment> getAllComments() {
            return oboCommentMapper.selectList(null);
        }


}
