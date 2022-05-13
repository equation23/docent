package org.zerock.sp1.service;

import org.zerock.sp1.domain.ImgFile;
import org.zerock.sp1.dto.ImageFileDTO;

public interface FileService {
    ImageFileDTO selectImg(Integer bno);
}
