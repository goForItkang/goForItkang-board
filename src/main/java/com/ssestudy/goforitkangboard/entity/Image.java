package com.ssestudy.goforitkangboard.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "image")
@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originName;

    private String realName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

}
