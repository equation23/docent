package com.docent.sp1.controller;

import com.docent.sp1.dto.ImageFileDTO;

import com.docent.sp1.dto.NoticeDTO;
import com.docent.sp1.mapper.FileMapper;
import com.docent.sp1.service.FileService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Controller
@Log4j2
@RequiredArgsConstructor

public class UploadController {



    @PostMapping("/upload")
    @ResponseBody
    public List<ImageFileDTO> upload(MultipartFile[] files){
        NoticeDTO noticeDTO = new NoticeDTO();

        List<ImageFileDTO> list = new ArrayList<>();

        for (MultipartFile file:files) {

            String originalFileName = file.getOriginalFilename();

            boolean img = file.getContentType().startsWith("image");

            String uuid = UUID.randomUUID().toString();

            String saveName = uuid +"_"+ originalFileName;

            String saveFolder = makeFolders();

            File saveFile = new File("C:\\projectFiles\\boardImage\\" +saveFolder+"\\"+saveName);

            try (InputStream in = file.getInputStream();
                 FileOutputStream fos = new FileOutputStream(saveFile);
            ){
                FileCopyUtils.copy(in, fos);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(img){
                //saveName = UUID+"_"+fileName
                String thumbFileName = saveFolder+"\\s_"+saveName;
                File thumbFile = new File("C:\\projectFiles\\boardImage\\" +thumbFileName);

                try {
                    Thumbnails.of(saveFile)
                            .size(200,200)
                            .toFile(thumbFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            ImageFileDTO imageFileDTO = ImageFileDTO.builder()
                    .fileName(originalFileName)
                    .uuid(uuid)
                    .img(img)
                    .savePath(saveFolder)
                    .build();


            list.add(imageFileDTO);
        }
        return list;
    }


    private String makeFolders(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        String str = sdf.format(new java.util.Date());

        File folderPath = new File("C:\\projectFiles\\boardImage\\" + str);

        if(!folderPath.exists()){
            folderPath.mkdirs();
        }
        return str;
    }
    @PostMapping("/delete")
    @ResponseBody
    public Map<String, String> deleteFile(String fileName){

        int idx = fileName.lastIndexOf("/");
        String path = fileName.substring(0,idx);
        String name = fileName.substring(idx+1); //uuid_fileName
        String uuid = name.substring(0,name.indexOf("_"));



        File targetFile = new File("C:\\projectFiles\\boardImage\\" + fileName);

        boolean result = targetFile.delete();

        //thumbnail
        if(result){
            File thumbFile = new File("C:\\projectFiles\\boardImage\\"+path+"\\s_"+name);
            thumbFile.delete();
        }


        return Map.of("result", "success");
    }
    @GetMapping("/view1")
    public ResponseEntity<byte[]> viewFile(String fileName) {

        File targetFileImg = new File("C:\\projectFiles\\boardImage\\" + fileName);

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
}

