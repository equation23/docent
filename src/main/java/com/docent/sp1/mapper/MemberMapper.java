package com.docent.sp1.mapper;

import com.docent.sp1.domain.DocentAuth;
import com.docent.sp1.domain.DocentMember;
import org.apache.ibatis.annotations.Insert;

public interface MemberMapper {

    @Insert("insert into tbl_dmember (did,dpw,dname,nickname) values (#{did}, #{dpw}, #{dname}, #{nickname})")
    void register(DocentMember member);

    @Insert("insert into tbl_dauth (did,rolename) values (#{did}, #{roleName})")
    void addAuth(DocentAuth auth);

    DocentMember selectOne(String did);
}
