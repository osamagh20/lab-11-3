package com.example.lab112.Controller;

import com.example.lab112.ApiResponse.ApiException;
import com.example.lab112.Model.Comment;
import com.example.lab112.Service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController

@RequestMapping("/api/v1/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping("/get")
    public ResponseEntity getComments(){
        List<Comment> comments = commentService.getAllComment();
        return ResponseEntity.status(200).body(comments);
    }

    @PostMapping("/add")
    public ResponseEntity addComment(@RequestBody @Valid Comment comment, Errors error){
        if (error.hasErrors()){
            String message = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        commentService.addComment(comment);
        return ResponseEntity.status(200).body(new ApiException("Comment added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id, @RequestBody @Valid Comment comment, Errors error){
        if (error.hasErrors()){
            String message = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        commentService.updateComment(id, comment);
        return ResponseEntity.status(200).body(new ApiException("Comment updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id){
        commentService.deleteComment(id);
        return ResponseEntity.status(200).body(new ApiException("Comment deleted"));
    }

    @GetMapping("/get-comment-by-user-id/{userid}")
    public ResponseEntity getCommentByUserId(@PathVariable Integer userid){
        List<Comment> comments = commentService.getCommentByUserId(userid);
        return ResponseEntity.status(200).body(comments);
    }

    @GetMapping("/get-comment-by-post-id/{postId}")
    public ResponseEntity getCommentByPostId(@PathVariable Integer postId){
        List<Comment> comments = commentService.getCommentByPostId(postId);
        return ResponseEntity.status(200).body(comments);
    }

    @GetMapping("/get-comment-by-date/{date}")
    public ResponseEntity getAllCommentsByDate(@PathVariable LocalDateTime date){
        List<Comment> commentByDate = commentService.getCommentByCommentDate(date);
        return ResponseEntity.status(200).body(commentByDate);
    }

}
