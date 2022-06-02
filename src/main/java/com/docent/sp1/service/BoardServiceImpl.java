package com.docent.sp1.service;

import com.docent.sp1.dto.BoardDTO;
import com.docent.sp1.dto.ImageFileDTO;
import com.docent.sp1.dto.ListDTO;
import com.docent.sp1.dto.ListResponseDTO;
import com.docent.sp1.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.docent.sp1.domain.Board;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService{
    private final ModelMapper modelMapper;
    private final BoardMapper boardMapper;

    @Override
    public ListResponseDTO<BoardDTO> getList(ListDTO listDTO) {

        List<Board> boardList = boardMapper.selectList(listDTO);

        List<BoardDTO> dtoList =
                boardList.stream()
                        .map(board -> modelMapper.map(board, BoardDTO.class))
                        .collect(Collectors.toList());

        return ListResponseDTO.<BoardDTO>builder()
                .dtoList(dtoList)
                .total(boardMapper.getTotal(listDTO))
                .build();
    }

    @Override
    public BoardDTO getOne(Integer bno) {
        Board board = boardMapper.selectOne(bno);

        BoardDTO boardDTO = modelMapper.map(board, BoardDTO.class);

        return boardDTO;
    }

    @Override
    public void update(BoardDTO boardDTO) {
        boardMapper.update(Board.builder()
                .bno(boardDTO.getBno())
                .title(boardDTO.getTitle())
                .introduce(boardDTO.getIntroduce())
                .build());
    }


    }

