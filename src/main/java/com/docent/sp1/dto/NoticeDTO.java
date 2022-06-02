package com.docent.sp1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDTO {

    private Integer bno;
    private String dname,title,content;

    private boolean img;

    private List<ImageFileDTO> uploads = new ArrayList<>();

    private LocalDateTime regdate, updateDate;

}
