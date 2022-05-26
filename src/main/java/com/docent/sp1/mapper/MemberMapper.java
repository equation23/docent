package com.docent.sp1.mapper;

import com.docent.sp1.domain.DAdmin;
import com.docent.sp1.domain.DocentMember;
import com.docent.sp1.dto.ListDTO;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface MemberMapper {

    @Insert("insert into tbl_dadmin (did,dpw,dname) values (#{did}, #{dpw}, #{dname})")
    void register(DAdmin dAdmin);

    DAdmin selectOne(String did);

    List<DocentMember> memberList(ListDTO listDTO);

    int getTotal(ListDTO listDTO);
}
