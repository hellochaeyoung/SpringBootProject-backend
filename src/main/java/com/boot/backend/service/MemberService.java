package com.boot.backend.service;

import com.boot.backend.dao.MemberDao;
import com.boot.backend.dto.MemberDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class MemberService {

    @Autowired
    MemberDao dao;

    public List<MemberDto> allMembers() {
        return dao.allMember();
    }
}
