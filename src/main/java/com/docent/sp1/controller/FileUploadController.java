package com.docent.sp1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


@Log4j2
@Controller
@RequiredArgsConstructor
public class FileUploadController {

    @GetMapping("/view")
    public ResponseEntity<byte[]> viewFile(String fileName) {

        File targetFileImg = new File("C:\\ProjectFiles\\image\\" + fileName);

        try {
            String mimeType = Files.probeContentType(targetFileImg.toPath());

            byte[] data = FileCopyUtils.copyToByteArray(targetFileImg);

            return ResponseEntity.ok().header("Content-Type", mimeType)
                    .body(data);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(404).build();
        }
    }
    @GetMapping("/audio")
    public ResponseEntity<byte[]> audioFile(String fileName) {
        File targetFileAudio = new File("C:\\ProjectFiles\\audio\\" + fileName);

        try {
            String mimeType = Files.probeContentType(targetFileAudio.toPath());

            byte[] data = FileCopyUtils.copyToByteArray(targetFileAudio);

            return ResponseEntity.ok().header("Content-Type", mimeType)
                    .body(data);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(404).build();
        }

    }


    @PostMapping("/upload1")
    @ResponseBody
    public void upload1(MultipartFile[] files) {
//        files
//        String originalFileName = file.getOriginalFilename();
//        String thumbFileName = "C:\\ProjectFiles\\image"+"\\s_"+saveName;
//        File thumbFile = new File("C:\\upload\\" +thumbFileName);
//
//        try {
//            Thumbnails.of(saveFile)
//                    .size(200,200)
//                    .toFile(thumbFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
    }
}
