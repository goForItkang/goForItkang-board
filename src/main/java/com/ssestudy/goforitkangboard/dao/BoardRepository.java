package com.ssestudy.goforitkangboard.dao;

import com.ssestudy.goforitkangboard.dto.BoardDTO;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BoardRepository {
    private EntityManager em;
    @Transactional
    public void boardSave(BoardDTO boardDTO) {
        em.persist(boardDTO);

    }
}
