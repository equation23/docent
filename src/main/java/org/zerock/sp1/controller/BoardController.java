package org.zerock.sp1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zerock.sp1.dto.BoardDTO;
import org.zerock.sp1.dto.ListDTO;
import org.zerock.sp1.dto.ListResponseDTO;
import org.zerock.sp1.dto.PageMaker;
import org.zerock.sp1.mapper.FileMapper;
import org.zerock.sp1.service.BoardService;
import org.zerock.sp1.service.FileService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/tr/")
@Controller
@Log4j2
public class BoardController {
    private final BoardService service;
    private final FileService fileService;

    @GetMapping("/")
    public String basic(){
        return "redirect:/tr/main";
    }
    @GetMapping("/main")
    public void main(ListDTO listDTO, Model model){

    }

    @GetMapping("/list")
    public void list(ListDTO listDTO, Model model) {

        ListResponseDTO<BoardDTO> responseDTO = service.getList(listDTO);

        model.addAttribute("dtoList", responseDTO.getDtoList());

        int total = responseDTO.getTotal();
        model.addAttribute("pageMaker", new PageMaker(listDTO.getPage(), total));

    }

    @GetMapping("/read/{bno}")
    public String read(@PathVariable("bno") Integer bno, ListDTO listDTO, Model model) {


        model.addAttribute("dto", service.getOne(bno));

        return "/tr/read";

    }

    @GetMapping("/modify/{bno}")
    public String modify(@PathVariable("bno") Integer bno, ListDTO listDTO, Model model) {


        model.addAttribute("dto", service.getOne(bno));

        return "/tr/modify";

    }
    @PostMapping("/modify/{bno}")
    public String postModify(@PathVariable("bno") Integer bno, BoardDTO boardDTO, ListDTO listDTO) {
        boardDTO.setBno(bno);

        log.info(boardDTO.getTitle());
        log.info(boardDTO.getClassify());
        log.info(boardDTO.getIntroduce());

        return "redirect:/tr/read/"+bno+listDTO.getLink();
    }
}


