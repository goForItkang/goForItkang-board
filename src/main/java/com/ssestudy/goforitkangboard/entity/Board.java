package com.ssestudy.goforitkangboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;
    @OneToMany(mappedBy = "board") //자신의 왜래키 이름 즉 하인의 자신 클래스이름
    private List<Image> images = new ArrayList<>();
}
