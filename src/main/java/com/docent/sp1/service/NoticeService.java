package com.docent.sp1.service;


import com.docent.sp1.dto.ImageFileDTO;
import com.docent.sp1.dto.ListDTO;
import com.docent.sp1.dto.ListResponseDTO;
import com.docent.sp1.dto.NoticeDTO;

import java.util.List;

public interface NoticeService {
    ListResponseDTO<NoticeDTO> getList (ListDTO listDTO);
    NoticeDTO getOne(Integer bno);
    void register(NoticeDTO noticeDTO);
    List<ImageFileDTO> getFiles(Integer bno);
}
