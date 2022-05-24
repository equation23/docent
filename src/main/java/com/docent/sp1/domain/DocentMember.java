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

    private LocalDateTime regDate,updateDate;

    private List<DocentAuth> docentAuthList ;
}
