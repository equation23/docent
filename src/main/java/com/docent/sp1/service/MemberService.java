package com.docent.sp1.service;

import com.docent.sp1.domain.DocentMember;
import com.docent.sp1.dto.DocentMemberDTO;
import com.docent.sp1.dto.ListDTO;
import com.docent.sp1.dto.ListResponseDTO;

import java.util.List;

public interface MemberService {

   ListResponseDTO<DocentMember> memberList(ListDTO listDTO);
}
