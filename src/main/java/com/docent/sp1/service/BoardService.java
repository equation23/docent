package com.docent.sp1.service;

import com.docent.sp1.dto.BoardDTO;
import com.docent.sp1.dto.ImageFileDTO;
import com.docent.sp1.dto.ListDTO;
import com.docent.sp1.dto.ListResponseDTO;

import java.util.List;

public interface BoardService {
    ListResponseDTO<BoardDTO> getList (ListDTO listDTO);
    BoardDTO getOne(Integer bno);
    void update(BoardDTO boardDTO);
    ListResponseDTO<BoardDTO> getAll (ListDTO listDTO);

}
