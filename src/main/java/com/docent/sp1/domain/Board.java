package com.docent.sp1.domain;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    public void setBno(Integer bno) {
        this.bno = bno;
    }

    private Integer bno;
    private String title;
    private String image;
    private String classify;
    private String location;
    private String introduce;
    private String audio;

    private LocalDateTime updateDate;
}
