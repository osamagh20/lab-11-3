package com.example.lab112.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    @NotNull(message = "Enter the user id")
    @Column(columnDefinition = "int not null")
    private Integer userId;
    @NotNull(message = "Enter the post id")
    @Column(columnDefinition = "int not null")
    private Integer postId;
    @NotEmpty(message = "Enter the content")
    @Column(columnDefinition = "varchar(20) not null")
    private String content;
    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private LocalDateTime commentDate;

    public Integer getCommentId() {
        return commentId;
    }

    public Integer getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCommentDate(LocalDateTime commentDate) {
        this.commentDate = commentDate;
    }


    @PrePersist
    public void prePersist() {
        if (commentDate == null)
            commentDate = LocalDateTime.now();
    }
}
