package com.boot.backend.dao;

import com.boot.backend.dto.BbsDto;
import com.boot.backend.dto.BbsParam;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BbsDao {

    BbsDto getBbs(int seq);

    int addBbs(BbsDto dto);

    List<BbsDto> getBbsByKeyword(BbsParam param);

    List<BbsDto> getBbsSearchPageList(BbsParam param);

    int getBbsCount(BbsParam param);
}
