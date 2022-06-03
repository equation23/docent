package com.docent.sp1.service;

import com.docent.sp1.controller.UploadController;
import com.docent.sp1.domain.ImgFile;
import com.docent.sp1.domain.Notice;
import com.docent.sp1.dto.ImageFileDTO;
import com.docent.sp1.dto.ListDTO;
import com.docent.sp1.dto.ListResponseDTO;
import com.docent.sp1.dto.NoticeDTO;
import com.docent.sp1.mapper.FileMapper;
import com.docent.sp1.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
@Log4j2
public class NoticeServiceImpl implements NoticeService{
private final NoticeMapper noticeMapper;
private final ModelMapper modelMapper;
private final FileMapper fileMapper;

    @Override
    public ListResponseDTO<NoticeDTO> getList(ListDTO listDTO) {
        List<Notice> noticeList = noticeMapper.noticeList(listDTO);

        List<NoticeDTO> dtoList =
                noticeList.stream()
                        .map(notice -> modelMapper.map(notice, NoticeDTO.class))
                        .collect(Collectors.toList());

        return ListResponseDTO.<NoticeDTO>builder()
                .dtoList(dtoList)
                .total(noticeMapper.getTotal(listDTO))
                .build();
    }

    @Override
    public NoticeDTO getOne(Integer bno) {
        Notice notice = noticeMapper.selectOne(bno);

        NoticeDTO noticeDTO = modelMapper.map(notice, NoticeDTO.class);

        return noticeDTO;
    }
    @Transactional
    @Override
    public void register(NoticeDTO noticeDTO) {
        Notice notice = modelMapper.map(noticeDTO, Notice.class);

        List<ImgFile> files =
                noticeDTO.getUploads().stream().map(imageFileDTO-> modelMapper.map(imageFileDTO, ImgFile.class)
                ).collect(Collectors.toList());


        noticeMapper.noticeInsert(notice);

        files.forEach(file -> fileMapper.insertImg(file));



    }

    @Override
    public List<ImageFileDTO> getFiles(Integer bno) {
        List<ImgFile> imgFiles = fileMapper.getImg(bno);

        return imgFiles.stream().map(imgFile -> modelMapper.map(imgFile, ImageFileDTO.class))
                .collect(Collectors.toList());
    }
}
