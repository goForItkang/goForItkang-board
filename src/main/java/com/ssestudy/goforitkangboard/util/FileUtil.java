package com.ssestudy.goforitkangboard.util;

import com.ssestudy.goforitkangboard.dto.ImageDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class FileUtil {
    private final String path = System.getProperty("user.dir") + "/uploads/";

    public void fileSave(ImageDTO imageDTO) throws IOException {
        File dirFile = new File(path);
        //저장할 디렉토리 생성 (존재하지 않을 경우)
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        } else { // 만약 디렉토리가 있다면
            System.out.println("디렉토리 있음: " + path);
            MultipartFile image = imageDTO.getImage();
            if (image != null && !image.isEmpty()) {
                File file = new File(path + imageDTO.getReName());
                try {
                    // 파일을 해당 경로에 저장
                    image.transferTo(file);
                    System.out.println("파일 저장됨: " + file.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();  // 예외 발생 시 출력
                    throw new IOException("파일 저장 실패", e);
                }
            } else {
                System.out.println("이미지 파일이 비어 있습니다.");
            }
        }

    }
}
