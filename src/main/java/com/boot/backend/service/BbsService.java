package com.boot.backend.service;

import com.boot.backend.dao.BbsDao;
import com.boot.backend.dto.BbsDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BbsService {

    @Autowired
    BbsDao dao;

    public List<BbsDto> getBbs() {
        return dao.getBbs();
    }
}
