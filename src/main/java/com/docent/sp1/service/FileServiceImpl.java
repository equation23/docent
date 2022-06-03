package com.docent.sp1.service;

import com.docent.sp1.domain.ImgFile;
import com.docent.sp1.dto.ImageFileDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.docent.sp1.mapper.FileMapper;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Log4j2
@Service
public class FileServiceImpl implements FileService{
    private final FileMapper fileMapper;
    private final ModelMapper modelMapper;

    @Override
    public void insert(ImageFileDTO imageFileDTO) {


        ImgFile imgFile=modelMapper.map(imageFileDTO,ImgFile.class);
        fileMapper.insertBoardImg(imgFile);
    }

    @Override
    public List<ImageFileDTO> getFiles(Integer bno) {
        List<ImgFile> imgFiles = fileMapper.getBoardImg(bno);

        return imgFiles.stream().map(imgFile -> modelMapper.map(imgFile, ImageFileDTO.class))
                .collect(Collectors.toList());
    }
}
