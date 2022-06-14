package com.docent.sp1.mapper;

import com.docent.sp1.domain.ImgFile;
import com.docent.sp1.dto.ImageFileDTO;

import java.util.List;

public interface FileMapper {

    List<ImgFile> getImg(Integer bno);
    void insertImg(ImgFile imgFile);
    void insertBoardImg(ImgFile imgFile);
    List<ImgFile> getBoardImg(Integer bno);
    void docUpdate(ImgFile imgFile);
    void docImgDelete(Integer bno);
    void updateBoardImage(ImgFile imgFile);
}
