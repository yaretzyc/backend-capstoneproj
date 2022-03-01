package com.example.bookclub.service;

import com.example.bookclub.exceptions.InformationNotFoundException;
import com.example.bookclub.model.Book;
import com.example.bookclub.model.Post;
import com.example.bookclub.repository.BookRepository;
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

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    //ALL POSTS
    public List<Post> allPosts(){
        return postRepository.findAll();
    }



//    //create post
//    public Post createPost(Post postObj){
//        System.out.println("Service calling create post method ==> ");
//        return postRepository.save(postObj);
//    }
    public Post createPost(Long bookId, Post postObj){
        System.out.println("service calling createPost");
        Optional<Book> book = bookRepository.findById(bookId);
            if(book.isPresent()){
                postObj.setBook(book.get());
                return postRepository.save(postObj);
            }else {
                throw new InformationNotFoundException("Book with Id " + bookId + " not found");
            }
    }
//
//    //get post list
//    public List<Post> getPostList(){
//        System.out.println("Service calling getPostList --> ");
//        return postRepository.findAll();
//    }
//
    public List<Post> getPostList(Long bookId){
        System.out.println("service calling getPostList");
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isPresent()){
            return book.get().getPostList();
        }else{
            throw new InformationNotFoundException("Book with an id of "+ bookId + " not found" );
        }
    }
//
////get one post
//
//    public Optional<Post> getOnePost(Long postId){
//        System.out.println("Service calling getOnePost ==>");
//        Optional<Post> post = postRepository.findById(postId);
//        if (post.isPresent()){
//            return post;
//        }else{
//            throw new InformationNotFoundException("post with id of " + postId +  " not found");
//        }
//    }
    public Optional<Post> getOnePost(Long bookId, Long postId){
        System.out.println("service calling getOnePost()");
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isPresent()){
            for(Post post: book.get().getPostList()){
                if(post.getId() == postId){
                    Post post1 = postRepository.findById(postId).get();
                    return Optional.of(post1);
                }
                throw new InformationNotFoundException("Post with id " + postId + " not found");
            }
        }
        throw new InformationNotFoundException("Book with id " + bookId + " not found");
    }

//
//    //update one post
//    public Post updatePost(Long postId, Post postObj){
//        System.out.println("service calling updatePost ==> ");
//        Optional<Post> post = postRepository.findById(postId);
//        if(post.isPresent()) {
//            Post updatePost = postRepository.findById(postId).get();
//            updatePost.setBody(postObj.getBody());
//            updatePost.setDate(postObj.getDate());
//            updatePost.setName(postObj.getName());
//            updatePost.setPage(postObj.getPage());
//            updatePost.setDateTime(postObj.getDateTime());
//            updatePost.setTitle(postObj.getTitle());
//
//            return postRepository.save(updatePost);
//        }
//        else {
//            throw new InformationNotFoundException("Post with id " + postId + " not found");
//        }
//
//    }
    public Post updatePost(Long bookId, Long postId, Post postObj){
        System.out.println("service calling updatePost");
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isPresent()){
            for(Post post: book.get().getPostList()){
                if(post.getId() == postId){
                    Post updatePost = postRepository.findById(postId).get();
                    updatePost.setBody(postObj.getBody());
                    updatePost.setDate(postObj.getDate());
                    updatePost.setName(postObj.getName());
                    updatePost.setPage(postObj.getPage());
                    updatePost.setDateTime(postObj.getDateTime());
                    updatePost.setTitle(postObj.getTitle());

                    return postRepository.save(updatePost);
                }
                throw new InformationNotFoundException("Post with id " + postId + " not found");
            }
        }
        throw new InformationNotFoundException("Book with id " + bookId + " not found");
    }


//
//
//    //delete one post
//    public Optional<Post> deletePost(Long postId){
//        System.out.println("Service calling deletePost ==> ");
//        Optional<Post> post = postRepository.findById(postId);
//        if(post.isPresent()) {
//            postRepository.deleteById(postId);
//            return post;
//        }else{
//            throw new InformationNotFoundException("post with id " + postId + " not found");
//        }
//
//    }

    public Optional<Post> deletePost(Long bookId, Long postId){
        System.out.println("service calling deletePost");
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isPresent()){
            for(Post post: book.get().getPostList()){
                if(post.getId() == postId){
                    Post post1 = postRepository.findById(postId).get();
                    postRepository.deleteById(postId);
                    return Optional.of(post1);
                }
                throw new InformationNotFoundException("Post with id " + postId + " not found");
            }
        }
        throw new InformationNotFoundException("Book with id " + bookId + " not found");
    }






}
