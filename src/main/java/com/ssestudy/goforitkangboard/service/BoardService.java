package com.ssestudy.goforitkangboard.service;

import com.ssestudy.goforitkangboard.dao.BoardRepository;
import com.ssestudy.goforitkangboard.dto.BoardDTO;
import com.ssestudy.goforitkangboard.dto.ImageDTO;
import com.ssestudy.goforitkangboard.entity.Board;
import com.ssestudy.goforitkangboard.entity.Image;
import com.ssestudy.goforitkangboard.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final FileUtil fileUtil;
    private final BoardRepository boardRepository;
    public void saveBoard(BoardDTO boardDTO,List<ImageDTO> imageDTOS) {
        System.out.println("ddd:"+imageDTOS);
        List<Image> images = new ArrayList<>();
        try {
            for (ImageDTO image : boardDTO.getImages()) {
                fileUtil.fileSave(image);

            }
        }catch (IOException e){
            e.printStackTrace();
        }
        Board board = changeBoard(boardDTO);
        List<Image> imageList = changeImage(imageDTOS);
        boardRepository.boardSave(board,imageList);
        System.out.println("boardService : imageList"+imageList);
        System.out.println("저장했음");
    }

    private Board changeBoard(BoardDTO boardDTO) {
        Board newBoard = new Board();
        newBoard.setTitle(boardDTO.getTitle());
        newBoard.setContent(boardDTO.getContent());
        return newBoard;
    }

    private List<Image> changeImage(List<ImageDTO> imageDTOS) {
        List<Image> images = new ArrayList<>();
        for (ImageDTO imageDTO : imageDTOS) {
            Image newImage = new Image();
            newImage.setOriginName(imageDTO.getOriginName());
            newImage.setRealName(imageDTO.getOriginName());
            images.add(newImage);
        }
        return images;
    }
    private BoardDTO entityToBoardDTO (Board board) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(board.getId());
        boardDTO.setTitle(board.getTitle());
        boardDTO.setContent(board.getContent());
        return boardDTO;
    }
    private List<ImageDTO> entityToImageDTO (List<Image> images) {
        List<ImageDTO> imageDTOS = new ArrayList<>();
        for (Image image : images) {
            ImageDTO imageDTO = new ImageDTO();
            imageDTO.setId(image.getId());
            imageDTO.setOriginName(image.getOriginName());
            imageDTO.setReName(image.getRealName());
            // util 작업에서 사진작업해줘야함
            imageDTOS.add(imageDTO);
        }
        return imageDTOS;
    }

    public BoardDTO boardGetOne(Long boardId) {
        Board board = boardRepository.selectById(boardId);
        BoardDTO boardDTO = entityToBoardDTO(board);
        List<ImageDTO> imageDTOS  =entityToImageDTO(board.getImages());
        boardDTO.setImages(imageDTOS);
        return boardDTO;
    }
}