package com.example.lab112.Controller;

import com.example.lab112.ApiResponse.ApiException;
import com.example.lab112.Model.Post;
import com.example.lab112.Service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/get")
    public ResponseEntity getPosts(){
        List<Post> posts = postService.getPosts();
        return ResponseEntity.status(200).body(posts);
    }

    @PostMapping("/add")
    public ResponseEntity addPost(@RequestBody @Valid Post post, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        postService.addPost(post);
        return ResponseEntity.status(200).body(new ApiException("Post added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePost(@PathVariable Integer id, @RequestBody @Valid Post post, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        postService.updatePost(id, post);
        return ResponseEntity.status(200).body(new ApiException("Post updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id){
        postService.deletePost(id);
        return ResponseEntity.status(200).body(new ApiException("Post deleted successfully"));
    }

    @GetMapping("/get-by-userid/{userId}")
    public ResponseEntity givePostsByUserId(@PathVariable Integer userId){
        List<Post> posts = postService.getPostsByUserId(userId);
        return ResponseEntity.status(200).body(posts);
    }

    @GetMapping("/get-by-title/{title}")
    public ResponseEntity givePostsByTitle(@PathVariable String title){
        Post post = postService.getPostByTitle(title);
        return ResponseEntity.status(200).body(post);
    }

    @GetMapping("/get-by-pub-date/{pubDate}")
    public ResponseEntity givePostsByPublishDate(@PathVariable LocalDateTime pubDate){
        List<Post> posts = postService.getPostsByPublishDate(pubDate);
        return ResponseEntity.status(200).body(posts);
    }

    @GetMapping("/get-by-lessDate/{pubDate}")
    public ResponseEntity givePostsByLessPublishDate(@PathVariable LocalDateTime pubDate){
        List<Post> posts = postService.getAllPostsBeforeDate(pubDate);
        return ResponseEntity.status(200).body(posts);
    }
}
