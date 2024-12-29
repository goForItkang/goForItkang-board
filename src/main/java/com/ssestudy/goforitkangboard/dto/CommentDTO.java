package com.ssestudy.goforitkangboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private Long Id;

    private String comment;

    private Date commentDate;

    private CommentDTO commentParent;

    private List<CommentDTO> childComments;
}
