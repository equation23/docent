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
    private String fileName;
    private String savePath;
    private boolean img;

    public void setBno(Integer bno) {
        this.bno = bno;
    }
}
