package com.boot.backend.dao;

import com.boot.backend.dto.ReadCountDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ReadCountDao {

    ReadCountDto getReadCount(ReadCountDto dto);

    int addReadCount(ReadCountDto dto);

    int deleteReadCount(int bbs);
}
