package com.docent.sp1.domain;

import lombok.*;

@Builder
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DocentAuth {

    private String did;
    private String roleName;
}
