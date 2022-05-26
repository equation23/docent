package com.docent.sp1.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class DocentMember {

    private String did,dpw,dname,nickname;
    private Integer score;

    private LocalDateTime regdate,updateDate;

}
