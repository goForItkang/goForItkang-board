package com.ssestudy.goforitkangboard.service;

import com.ssestudy.goforitkangboard.dao.BoardRepository;
import com.ssestudy.goforitkangboard.dto.BoardDTO;
import com.ssestudy.goforitkangboard.dto.ImageDTO;
import com.ssestudy.goforitkangboard.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final FileUtil fileUtil;
    private final BoardRepository boardRepository;
    public void saveBoard(BoardDTO boardDTO) {
        try {
            for (ImageDTO image : boardDTO.getImages()) {
                fileUtil.fileSave(image);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        boardRepository.boardSave(boardDTO);
        System.out.println("저장했음");
    }
}
