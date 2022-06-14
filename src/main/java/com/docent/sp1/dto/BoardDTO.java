package com.docent.sp1.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class BoardDTO {
    private Integer bno;
    private String title;
    private String image;
    private String classify;
    private String location;
    private String introduce;
    private String audio;

    private LocalDateTime updateDate;

    private List<ImageFileDTO> uploads = new ArrayList<>();
}
