package com.example.bookclub.controller;

import com.example.bookclub.model.Book;
import com.example.bookclub.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
//CREATE
    @PostMapping("")
    public Book createBook (@RequestBody Book bookObj){
        return bookService.createBook(bookObj);
    }
//GET ALL BOOKS
    @GetMapping("/books/")
    public List<Book> getBookList(){
        return bookService.getBookList();
    }

 //GET ONE BOOK
    @GetMapping("/{bookId}/")
    public Optional<Book> getOneBook(@PathVariable(value = "bookId")Long bookId){
        return bookService.getOneBook(bookId);
    }


//UPDATE ONE BOOK
    @PutMapping("/{bookId}/")
    public Book updateBook(@PathVariable(value = "bookId")Long bookId,
                           @RequestBody Book bookObj){
        return bookService.updateBook(bookId, bookObj);
    }



//delete one book
    @DeleteMapping("/{bookId}/")
    public Optional<Book> deleteBook(@PathVariable (value = "bookId") Long bookId) {

        return bookService.deleteBook(bookId);
    }













}
