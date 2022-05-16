package com.docent.sp1.service;

import com.docent.sp1.domain.ImgFile;
import com.docent.sp1.dto.ImageFileDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.docent.sp1.mapper.FileMapper;
@RequiredArgsConstructor
@Log4j2
@Service
public class FileServiceImpl implements FileService{
    private final FileMapper fileMapper;
    private final ModelMapper modelMapper;

    @Override
    public ImageFileDTO selectImg(Integer bno) {
        ImgFile imgFile = fileMapper.getImg(bno);
        ImageFileDTO imageFileDTO=modelMapper.map(imgFile,ImageFileDTO.class);
        return  imageFileDTO;
    }
}
