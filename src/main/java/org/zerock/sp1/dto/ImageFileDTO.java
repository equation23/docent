package org.zerock.sp1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ImageFileDTO {
    private String uuid;
    private Integer bno;
    private String image;
    private String savepath;
}