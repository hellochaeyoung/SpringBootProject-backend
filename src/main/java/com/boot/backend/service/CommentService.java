package com.boot.backend.service;

import com.boot.backend.dao.CommentDao;
import com.boot.backend.dto.CommentDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentDao dao;

    public int addComment(CommentDto dto) {
        return dao.addComment(dto);
    }

    public List<CommentDto> getCommentList(int bbs) {
        return dao.getCommentList(bbs);
    }
}
