package com.ssestudy.goforitkangboard.entity;

import jakarta.persistence.*;

@Table(name = "image")
@Entity
public class Image {
    @Id
    @GeneratedValue
    private Long id;

    private String originName;

    private String realName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

}
