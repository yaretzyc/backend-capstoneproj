package com.example.bookclub.service;

import com.example.bookclub.exceptions.InformationNotFoundException;
import com.example.bookclub.model.Post;
import com.example.bookclub.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public void setPostRepository(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    //create post
    public Post createPost(Post postObj){
        System.out.println("Service calling create post method ==> ");
        return postRepository.save(postObj);
    }

    //get post list
    public List<Post> getPostList(){
        System.out.println("Service calling getPostList --> ");
        return postRepository.findAll();
    }


//get one post

    public Optional<Post> getOnePost(Long postId){
        System.out.println("Service calling getOnePost ==>");
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()){
            return post;
        }else{
            throw new InformationNotFoundException("post with id of " + postId +  " not found");
        }
    }

    //update one post
    public Post updatePost(Long postId, Post postObj){
        System.out.println("service calling updatePost ==> ");
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()) {
            Post updatePost = postRepository.findById(postId).get();
            updatePost.setBody(postObj.getBody());
            updatePost.setDate(postObj.getDate());
            updatePost.setName(postObj.getName());
            updatePost.setPage(postObj.getPage());
            updatePost.setDateTime(postObj.getDateTime());
            updatePost.setTitle(postObj.getTitle());

            return postRepository.save(updatePost);
        }
        else {
            throw new InformationNotFoundException("Post with id " + postId + " not found");
        }

    }


    //delete one post
    public Optional<Post> deletePost(Long postId){
        System.out.println("Service calling deletePost ==> ");
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()) {
            postRepository.deleteById(postId);
            return post;
        }else{
            throw new InformationNotFoundException("post with id " + postId + " not found");
        }

    }






}
