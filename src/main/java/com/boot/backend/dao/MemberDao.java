package com.boot.backend.dao;

import com.boot.backend.dto.MemberDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberDao {

    List<MemberDto> allMember();

    int addMember(MemberDto dto);

    String getId(String id);

}
