package com.blog.controller.post;

import com.blog.model.post.Post;
import com.blog.requests.CreatePostRequest;
import com.blog.requests.PostResponse;
import com.blog.service.post.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    ResponseEntity<List<PostResponse>> getAllPost(){
        Collection<Post> posts = postService.getAllPost();
        List<PostResponse> responses = new ArrayList<PostResponse>();
        for(Post post:posts){
            PostResponse response = new PostResponse(post);
            responses.add(response);
        }
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/post/{id}")
    ResponseEntity<?> getPostById(@PathVariable Long id){
        Post post = postService.getPostById(id);
        if(post == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No post exists with given id");
        PostResponse postResponse = new PostResponse(post);
        return ResponseEntity.ok(postResponse);
    }

    @PostMapping("/post")
    ResponseEntity<?> createPost(@RequestBody CreatePostRequest request){
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setTitleImageUrl(request.getTitleImageUrl());
        post = postService.createPost(post,request.getAuthor());
        return ResponseEntity.ok("Post Created with id "+post.getPostId());
    }

    @PutMapping("/post")
    ResponseEntity<?> updatePost(@RequestBody Post post){
        Post updatePost = postService.updatePost(post);
        if(updatePost==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post doesn't exist");
        return ResponseEntity.ok("Successfully updated post with id: "+updatePost.getPostId());
    }

    @DeleteMapping("/post/{id}")
    ResponseEntity<?> deletePostById(@PathVariable Long id){
        if(postService.deletePostById(id)){
            return ResponseEntity.ok().body("Successfully delete post with id:"+id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No post found");
    }
}
