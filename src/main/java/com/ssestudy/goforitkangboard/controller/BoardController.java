package com.ssestudy.goforitkangboard.controller;

import com.ssestudy.goforitkangboard.dto.BoardDTO;
import com.ssestudy.goforitkangboard.dto.ImageDTO;
import com.ssestudy.goforitkangboard.entity.Board;
import com.ssestudy.goforitkangboard.entity.Image;
import com.ssestudy.goforitkangboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;
    @PostMapping(value = "/api/board/save",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> boardSave(
            @RequestPart BoardDTO boardDTO,
            @RequestPart("images") List<MultipartFile> images
    ) {
        System.out.println(images.size());
        // 정보를 받아와서 imageDTO정보를 다시 정보 처리함
        List<ImageDTO> imageDTOS = new ArrayList<>();
        for(int i = 0; i<images.size(); i++){
            ImageDTO imageDTO = new ImageDTO();
            imageDTO.setOriginName(images.get(i).getOriginalFilename());
            imageDTO.setReName(System.currentTimeMillis()+"_"+imageDTO.getOriginName());
            imageDTO.setImage(images.get(i));
            imageDTOS.add(imageDTO);
        }
        System.out.println("boardController: " + imageDTOS);
        boardDTO.setImages(imageDTOS);
        boardService.saveBoard(boardDTO,imageDTOS);

        System.out.println(boardDTO);
        return ResponseEntity.ok("success");
    }

//    @GetMapping("/api/board/{boardId}")
//    public ResponseEntity<BoardDTO> getBoard(@PathVariable Long boardId){
//        //BoardDTO boardDTO = boardService.boardGetOne(boardId); // 보드번호로 가져오기
//
//        return ResponseEntity.ok();
//    }
}
