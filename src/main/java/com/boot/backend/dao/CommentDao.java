package com.boot.backend.dao;

import com.boot.backend.dto.CommentDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommentDao {

    int addComment(CommentDto dto);

    List<CommentDto> getCommentList(int bbs);

    int deleteComments(int bbs);
}
