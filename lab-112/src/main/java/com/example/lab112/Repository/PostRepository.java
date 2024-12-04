package com.example.lab112.Repository;

import com.example.lab112.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findPostByPostId(Integer id);

    List<Post> findPostByUserId(Integer userId);

    @Query("select p from Post p where p.title=?1")
    Post getPostByTitle(String title);

    List<Post> findPostByPublishDate(LocalDateTime publishDate);


    @Query("select p from Post p where p.publishDate<=?1")
    List<Post> getAllPostsBeforeDate(LocalDateTime publishDate);


}
