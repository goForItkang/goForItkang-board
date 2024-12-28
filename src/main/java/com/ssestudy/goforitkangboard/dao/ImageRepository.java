package com.ssestudy.goforitkangboard.dao;

import com.ssestudy.goforitkangboard.entity.Image;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ImageRepository {
    private final EntityManager em;

    public void ImageSave(Image image) {
        em.persist(image);
    }
}
