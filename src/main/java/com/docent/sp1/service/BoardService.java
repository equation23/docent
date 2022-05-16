package com.docent.sp1.service;

import com.docent.sp1.dto.BoardDTO;
import com.docent.sp1.dto.ListDTO;
import com.docent.sp1.dto.ListResponseDTO;

public interface BoardService {
    ListResponseDTO<BoardDTO> getList (ListDTO listDTO);
    BoardDTO getOne(Integer bno);

}
