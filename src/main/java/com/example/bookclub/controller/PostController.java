package com.example.bookclub.controller;

import com.example.bookclub.model.Post;
import com.example.bookclub.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
public class PostController {

    @Autowired
    public PostService postService;

    //get hello world
//    @GetMapping(path = "/hello-world/")
//    public String getHelloWorld(){
//        return "hello world";
//    }



    //CREATE
    @PostMapping("/post/")
    public Post createPost (@RequestBody Post postObj){
        return postService.createPost(postObj);
    }
    //GET ALL POSTS
    @GetMapping("/posts/")
    public List<Post> getPostList(){
        return postService.getPostList();
    }

    //GET ONE POST
    @GetMapping("/post/{postId}/")
    public Optional<Post> getOnePost(@PathVariable(value = "postId")Long postId){
        return postService.getOnePost(postId);
    }


    //UPDATE ONE post
    @PutMapping("/post/{postId}/")
    public Post updatePost(@PathVariable(value = "postId")Long postId,
                           @RequestBody Post postObj){
        return postService.updatePost(postId, postObj);
    }



    //delete one post
    @DeleteMapping("/post/{postId}/")
    public Optional<Post> deletePost(@PathVariable (value = "postId") Long postId) {

        return postService.deletePost(postId);
    }

}
