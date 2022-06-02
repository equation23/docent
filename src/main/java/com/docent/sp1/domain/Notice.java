package com.docent.sp1.domain;

import lombok.*;


import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    public void setBno(Integer bno) {
        this.bno = bno;
    }
    private Integer bno;

    private String dname,title ,content;

    private boolean img;

    private LocalDateTime regdate, updateDate;

}
