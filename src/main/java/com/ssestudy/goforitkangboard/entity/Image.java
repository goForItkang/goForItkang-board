package com.ssestudy.goforitkangboard.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Table(name = "image")
@Entity
@Data
@ToString(exclude = "board")
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
