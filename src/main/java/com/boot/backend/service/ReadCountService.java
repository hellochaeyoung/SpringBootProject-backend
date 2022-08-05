package com.boot.backend.service;

import com.boot.backend.dao.ReadCountDao;
import com.boot.backend.dto.ReadCountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadCountService {

    @Autowired
    ReadCountDao dao;

    public ReadCountDto getReadCount(ReadCountDto dto) {
        return dao.getReadCount(dto);
    }

    public int addReadCount(ReadCountDto dto) {
        return dao.addReadCount(dto);
    }

    public int deleteReadCount(int bbs) {
        return dao.deleteReadCount(bbs);
    }
}
