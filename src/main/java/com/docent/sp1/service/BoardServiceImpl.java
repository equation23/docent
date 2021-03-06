package com.docent.sp1.service;

import com.docent.sp1.domain.ImgFile;
import com.docent.sp1.dto.BoardDTO;
import com.docent.sp1.dto.ImageFileDTO;
import com.docent.sp1.dto.ListDTO;
import com.docent.sp1.dto.ListResponseDTO;
import com.docent.sp1.mapper.BoardMapper;
import com.docent.sp1.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.docent.sp1.domain.Board;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {
    private final ModelMapper modelMapper;
    private final BoardMapper boardMapper;
    private final FileService fileService;
    private final FileMapper fileMapper;

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
    @Transactional
    @Override
    public void update(BoardDTO boardDTO) {

        fileService.delete(boardDTO.getBno());

        boardMapper.update(Board.builder()
                .bno(boardDTO.getBno())
                .title(boardDTO.getTitle())
                .classify(boardDTO.getClassify())
                .image(boardDTO.getImage())
                .location(boardDTO.getLocation())
                .introduce(boardDTO.getIntroduce())
                .build());

        for (ImageFileDTO imageFileDTO : boardDTO.getUploads()) {

            ImgFile imgFile = modelMapper.map(imageFileDTO, ImgFile.class);
            imgFile.setBno(boardDTO.getBno());
            // ????????? uploadresultDTO??? qano??? ???????????? ?????? qano??? ?????? ??? ?????????
            // attach File??? ????????? setter??? ?????????
            //todo check ?????? ????????? ?????? ??? ???????????? + ??????????????? ????????? ????????????
            fileMapper.updateBoardImage(imgFile);
        }// ???????????? ?????? ?????? ??????
    }

    @Override
    public ListResponseDTO<BoardDTO> getAll(ListDTO listDTO) {
        List<Board> boardList = boardMapper.selectAllList(listDTO);

        List<BoardDTO> dtoList =
                boardList.stream()
                        .map(board -> modelMapper.map(board, BoardDTO.class))
                        .collect(Collectors.toList());

        return ListResponseDTO.<BoardDTO>builder()
                .dtoList(dtoList)
                .total(boardMapper.getTotal(listDTO))
                .build();
    }
}

