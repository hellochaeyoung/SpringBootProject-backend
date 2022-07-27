package com.boot.backend.service;

import com.boot.backend.dao.BbsDao;
import com.boot.backend.dto.BbsDto;
import com.boot.backend.dto.BbsParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BbsService {

    @Autowired
    BbsDao dao;

    public BbsDto getBbs(int seq) {
        return dao.getBbs(seq);
    }

    public boolean addBbs(BbsDto dto) {
        int result = dao.addBbs(dto);
        return result > 0;
    }

    public List<BbsDto> getBbsByKeyword(BbsParam param) {
        return dao.getBbsByKeyword(param);
    }

    public List<BbsDto> getBbsSearchPageList(BbsParam param) {
        return dao.getBbsSearchPageList(param);
    }

    public int getBbsCount(BbsParam param) {
        return dao.getBbsCount(param);
    }
}
