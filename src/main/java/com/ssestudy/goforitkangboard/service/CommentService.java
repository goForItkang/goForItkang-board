package com.ssestudy.goforitkangboard.service;

import com.ssestudy.goforitkangboard.dao.CommentRepository;
import com.ssestudy.goforitkangboard.dto.CommentDTO;
import com.ssestudy.goforitkangboard.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    private Comment CommentDTOToComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setComment(commentDTO.getComment());
        comment.setCommentDate(commentDTO.getCommentDate());
        if (commentDTO.getCommentParent() != null){
            Comment parentComment = CommentDTOToComment(commentDTO.getCommentParent());
            comment.setCommentParent(parentComment);
        }
        if(commentDTO.getChildComments() != null && !commentDTO.getChildComments().isEmpty()){
            List<Comment> commentList = new ArrayList<>();
            for(CommentDTO childCommentDTO : commentDTO.getChildComments()){
                Comment childComment = CommentDTOToComment(childCommentDTO);
                childComment.setCommentParent(comment); // 부모 설정
                commentList.add(childComment);
            }
            comment.setChildComments(commentList);
        }
        return comment;

    }

    public void commentSave(CommentDTO commentDTO) {
        Comment comment = CommentDTOToComment(commentDTO);

    }
}
