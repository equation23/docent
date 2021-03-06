package com.docent.sp1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ImageFileDTO {
    private String uuid;
    private Integer bno;
    private String fileName;
    private String savePath;
    private boolean img;

    public ImageFileDTO(){

    }

    public String getLink(){
        return uuid+"_"+fileName;
    }
    public String getThumbnail(){
        return "/s_"+uuid+"_"+fileName;
    }

}