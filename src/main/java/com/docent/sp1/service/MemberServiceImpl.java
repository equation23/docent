package com.docent.sp1.service;

import com.docent.sp1.domain.Board;
import com.docent.sp1.domain.DocentMember;
import com.docent.sp1.dto.BoardDTO;
import com.docent.sp1.dto.DocentMemberDTO;
import com.docent.sp1.dto.ListDTO;
import com.docent.sp1.dto.ListResponseDTO;
import com.docent.sp1.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
private final MemberMapper memberMapper;
private final ModelMapper modelMapper;

    @Override
    public ListResponseDTO<DocentMember> memberList(ListDTO listDTO) {
        List<DocentMember> memberList = memberMapper.memberList(listDTO);

        List<DocentMember> dtoList =
                memberList.stream()
                        .map(member -> modelMapper.map(member, DocentMember.class))
                        .collect(Collectors.toList());

        return ListResponseDTO.<DocentMember>builder()
                .dtoList(dtoList)
                .total(memberMapper.getTotal(listDTO)   )
                .build();
    }
}
