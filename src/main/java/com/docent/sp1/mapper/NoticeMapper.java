package com.docent.sp1.mapper;

import com.docent.sp1.domain.Board;
import com.docent.sp1.domain.Notice;
import com.docent.sp1.dto.ListDTO;

import java.util.List;

public interface NoticeMapper {

    void noticeInsert (Notice notice);

    List<Notice> noticeList(ListDTO listDTO);

    int getTotal(ListDTO listDTO);

    Notice selectOne (Integer bno);


}
