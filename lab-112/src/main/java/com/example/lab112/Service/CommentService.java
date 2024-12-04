package com.example.lab112.Service;

import com.example.lab112.ApiResponse.ApiException;
import com.example.lab112.Model.Comment;
import com.example.lab112.Repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service

public class CommentService {
     final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    public List<Comment> getAllComment(){
        return commentRepository.findAll();
    }
    public void addComment(Comment comment){
         commentRepository.save(comment);
    }
    public void updateComment(Integer id,Comment comment){
        Comment oldComment = commentRepository.findCommentByCommentId(id);
        if(oldComment == null){
            throw new ApiException("id not found");
        }
        oldComment.setCommentId(comment.getCommentId());
        oldComment.setUserId(comment.getUserId());
        oldComment.setPostId(comment.getPostId());
        oldComment.setContent(comment.getContent());
        oldComment.setCommentDate(comment.getCommentDate());
        commentRepository.save(oldComment);
    }
    public void deleteComment(Integer id){
        Comment delComment = commentRepository.findCommentByCommentId(id);
        if(delComment == null){
            throw new ApiException("id not found");
        }
        commentRepository.delete(delComment);
    }


    public List<Comment> getCommentByUserId(Integer userId){
        List<Comment> commentList = commentRepository.getCommentByUserId(userId);
        if(commentList == null){
            throw new ApiException("userId not found");
        }
        return commentList;
    }

    public List<Comment> getCommentByPostId(Integer postId){
        List<Comment> commentList = commentRepository.getCommentByPostId(postId);
        if(commentList == null){
            throw new ApiException("postId not found");
        }
        return commentList;
    }

    public List<Comment> getCommentByCommentDate(LocalDateTime commentDate){
        List<Comment> commentList = commentRepository.getAllCommentsByDate(commentDate);
        if(commentList == null){
            throw new ApiException("commentDate not found");
        }
        return commentList;
    }
}
