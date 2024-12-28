package com.ssestudy.goforitkangboard.dao;

import com.ssestudy.goforitkangboard.dto.BoardDTO;
import com.ssestudy.goforitkangboard.entity.Board;
import com.ssestudy.goforitkangboard.entity.Image;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final EntityManager em;
    private final ImageRepository imageRepository;
    @Transactional
    public void boardSave(Board board, List<Image> images) {
        em.persist(board);

        for (Image image : images) {
            System.out.println("이미지 대한 정보"+image);
            image.setBoard(board); // 관계설정 board_id에 대한것 설정~
            em.persist(image);
        }
    }
}
