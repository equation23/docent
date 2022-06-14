package com.docent.sp1.service;

import com.docent.sp1.dto.ImageFileDTO;

import java.util.List;

public interface FileService {
    void insert (ImageFileDTO imageFileDTO);
    List<ImageFileDTO> getFiles(Integer bno);
    void update (ImageFileDTO imageFileDTO);
    void delete (Integer bno);
}
