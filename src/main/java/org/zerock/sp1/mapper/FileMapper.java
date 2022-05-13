package org.zerock.sp1.mapper;

import org.zerock.sp1.domain.ImgFile;

public interface FileMapper {
    void insertImg(ImgFile imgFile);
    ImgFile getImg(Integer bno);

}
