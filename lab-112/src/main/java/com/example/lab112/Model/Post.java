package com.example.lab112.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @NotNull(message = "Enter the category id")
    @Column(columnDefinition = "int not null")
    private Integer categoryId;
    @NotEmpty(message = "Enter the title")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;
    @NotEmpty(message = "Enter the content")
    @Column(columnDefinition = "varchar(20) not null")
    private String content;
    @NotNull(message = "Enter the user id")
    @Column(columnDefinition = "int not null")
    private Integer userId;
    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private LocalDateTime publishDate;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    @PrePersist
    public void prePersist() {
        if (publishDate == null)
            publishDate = LocalDateTime.now();
    }
}
