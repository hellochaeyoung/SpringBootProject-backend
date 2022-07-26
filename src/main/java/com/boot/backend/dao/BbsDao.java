package com.boot.backend.dao;

import com.boot.backend.dto.BbsDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BbsDao {

    List<BbsDto> getBbs();
}
