package com.boot.backend.service;

import com.boot.backend.dao.MemberDao;
import com.boot.backend.dto.MemberDto;
import java.util.List;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    MemberDao dao;

    private static final String LOGIN = "LOGIN";
    private final HttpSession session;

    public List<MemberDto> allMembers() {
        return dao.allMember();
    }

    public int addMember(MemberDto dto) {
        return dao.addMember(dto);
    }

    public boolean getId(MemberDto dto) {

        String result = dao.getId(dto.getId());

        if(result != null) {
            return true;
        }else {
            return false;
        }
    }

    public MemberDto login(MemberDto dto) {

        MemberDto loginMember = dao.login(dto);

        if(loginMember != null) {
            session.setAttribute(LOGIN, dto);
        }

        return loginMember;
    }

    public MemberDto getCurrentMember() {
        return (MemberDto) session.getAttribute(LOGIN);
    }

    public void logout() {
        session.removeAttribute(LOGIN);
    }
}
