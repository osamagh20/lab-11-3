package com.example.lab112.Repository;

import com.example.lab112.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment findCommentByCommentId(Integer id);

    @Query("select c from Comment c where c.userId=?1")
    List<Comment> getCommentByUserId(Integer id);

    @Query("select c from Comment c where c.postId=?1")
    List<Comment> getCommentByPostId(Integer id);


    @Query("select c from Comment c where c.commentDate=?1")
    List<Comment> getAllCommentsByDate(LocalDateTime date);


}
