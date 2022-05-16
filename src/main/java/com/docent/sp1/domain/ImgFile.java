package com.docent.sp1.domain;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ImgFile {
    private String uuid;
    private Integer bno;
    private String image;
    private String savepath;

}
