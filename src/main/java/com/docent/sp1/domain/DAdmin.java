package com.docent.sp1.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class DAdmin {
    private String did,dpw,dname,rolename;
    private LocalDateTime regdate,updateDate;

    private List<DAdmin> dAdminList ;
}
