package com.ssestudy.goforitkangboard.controller;

import com.ssestudy.goforitkangboard.dto.CommentDTO;
import com.ssestudy.goforitkangboard.entity.Comment;
import com.ssestudy.goforitkangboard.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    //댓글에 작성된 댓글
    @PostMapping("/comment/save/{boardId}")
    public ResponseEntity<String> saveComment
            (@PathVariable Long boardId,
             @RequestBody CommentDTO commentDTO) {
        System.out.println(commentDTO);
        commentService.commentSave(commentDTO);
        return ResponseEntity.ok("success");
    }

}
