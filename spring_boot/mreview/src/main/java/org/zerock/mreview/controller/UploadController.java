package org.zerock.mreview.controller;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.mreview.dto.UploadResultDTO;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
public class UploadController {

    @Value("${org.zerock.upload.path}")
    private String uploadPath;

    @PostMapping("/uploadAjax")
    public ResponseEntity<List<UploadResultDTO>> uploadFile(MultipartFile[] uploadFiles) {
        List<UploadResultDTO> resultDTOList = new ArrayList<>();

        for (MultipartFile f : uploadFiles) {
            // 이미지만 가능(이미지파일이 아니면 중지)
            if (f.getContentType().startsWith("image") == false) {
                log.warn("this file is not image type");
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
            String originalFilename = f.getOriginalFilename(); //원본파일명
            String fileName = originalFilename.substring(originalFilename.lastIndexOf("\\")+1);

            log.info("fileName:"+fileName);

            // 폴더 생성
            String folderPath = makeFolder();

            // UUID
            String uuid = UUID.randomUUID().toString();

            // D:\file_repo\2025...{uuid}_파일명
            String saveName = uploadPath+ File.separator+folderPath+File.separator+uuid+"_"+fileName;
            Path savePath = Paths.get(saveName); // 경로

            try {
                f.transferTo(savePath); // 저장

                // 썸네일 생성
                String thumbnailSaveName = uploadPath + File.separator+folderPath+File.separator+"s_"+uuid+"_"+fileName;
                File thumbnailFile = new File(thumbnailSaveName);
                Thumbnailator.createThumbnail(savePath.toFile(), thumbnailFile, 100,100);

                // 리스트에 추가
                resultDTOList.add(new UploadResultDTO(fileName, uuid, folderPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(resultDTOList, HttpStatus.OK);
    }
    private String makeFolder() {
        // 현재날짜 2025/02/17
        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        // "/" -> 운영체제의 구분자(W:\, L/U/M:/)
        String folderPath = str.replace("/", File.separator);

        // 파일객체 생성 : D:\file_repo\2025\02\17
        File uploadPathFolder = new File(uploadPath, folderPath);
        if (!uploadPathFolder.exists()) { // 해당경로가 존재하지 않으면
            uploadPathFolder.mkdirs(); // mkdir -> 디렉토리 생성
        }
        return folderPath;
    }
    @GetMapping("/display")
    public ResponseEntity<byte[]> getFile(String fileName) {
        ResponseEntity<byte[]> result = null;

        try {
            String srcFileName = URLDecoder.decode(fileName,"UTF-8");
            File file = new File(uploadPath + File.separator + srcFileName);

            if (file.length() == 1) {
                file = new File(file.getParent(), file.getName().substring(2));
            }

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", Files.probeContentType(file.toPath()));
            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }

    @PostMapping("/removeFile")
    public ResponseEntity<Boolean> removeFile(String fileName) {
        String srcFileName = null;

        try {
            srcFileName = URLDecoder.decode(fileName,"UTF-8");
            File file = new File(uploadPath + File.separator + srcFileName);
            boolean result = file.delete(); // 이미지 삭제

            File thumbnail = new File(file.getParent(), "s_"+file.getName());
            result = thumbnail.delete(); // 썸네일 삭제

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
