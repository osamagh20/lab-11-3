package com.example.lab112.Service;

import com.example.lab112.ApiResponse.ApiException;
import com.example.lab112.Model.Post;
import com.example.lab112.Repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service

public class PostService {
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    public void addPost(Post post){
        postRepository.save(post);
    }

    public void updatePost(Integer id,Post post){
        Post oldPost = postRepository.findPostByPostId(id);
        if(oldPost == null){
            throw new ApiException("id not found");
        }
        oldPost.setCategoryId(post.getCategoryId());
        oldPost.setTitle(post.getTitle());
        oldPost.setContent(post.getContent());
        oldPost.setUserId(post.getUserId());
        oldPost.setPublishDate(post.getPublishDate());
        postRepository.save(oldPost);
    }

    public void deletePost(Integer id){
        Post delPost = postRepository.findPostByPostId(id);
        if(delPost == null){
            throw new ApiException("id not found");
        }
        postRepository.delete(delPost);
    }

    public List<Post> getPostsByUserId(Integer userId){
        List<Post> postsByUserId = postRepository.findPostByUserId(userId);
        if(postsByUserId == null){
            throw new ApiException("userId not found");
        }
        return postsByUserId;
    }

    public Post getPostByTitle(String title){
        Post post = postRepository.getPostByTitle(title);
        if(post == null){
            throw new ApiException("title not found");
        }
        return post;
    }

    public List<Post> getPostsByPublishDate(LocalDateTime publishdate){
        List<Post> postsByPublishDate = postRepository.findPostByPublishDate(publishdate);
        if(postsByPublishDate == null){
            throw new ApiException("publishDate not found");
        }
        return postsByPublishDate;
    }

    public List<Post> getAllPostsBeforeDate(LocalDateTime lessPublishdate){
        List<Post> postsByLessPublishDate = postRepository.getAllPostsBeforeDate(lessPublishdate);
        if(postsByLessPublishDate == null){
            throw new ApiException("not found any post before this publish Date");
        }
        return postsByLessPublishDate;
    }



}
