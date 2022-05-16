package com.docent.sp1.service;

import com.docent.sp1.dto.ImageFileDTO;

public interface FileService {
    ImageFileDTO selectImg(Integer bno);
}
