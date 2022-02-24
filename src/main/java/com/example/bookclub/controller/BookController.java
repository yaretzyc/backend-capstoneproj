package com.example.bookclub.controller;

import com.example.bookclub.model.Book;
import com.example.bookclub.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/book")
public class BookController {

    @Autowired
    public BookService bookService;

    //get hello world
    @GetMapping(path = "/hello-world/")
    public String getHelloWorld(){
        return "hello world";
    }

    ////////////////////BOOKS \\\\\\\\\\\\\\\\\\\\\

    @PostMapping("book")
    public Book createBook (@RequestBody Book bookObj){
        return bookService.createBook(bookObj);
    }

    public List<Book> getBookList(){
        return bookService.getBookList();
    }
















}
