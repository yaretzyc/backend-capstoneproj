package com.example.bookclub.controller;

import com.example.bookclub.model.Book;
import com.example.bookclub.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
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
    @PostMapping("/book/")
    public Book createBook (@RequestBody Book bookObj){
        return bookService.createBook(bookObj);
    }
//GET ALL BOOKS
    @GetMapping("/books/")
    public List<Book> getBookList(){
        return bookService.getBookList();
    }

 //GET ONE BOOK
    @GetMapping("/book/{bookId}/")
    public Optional<Book> getOneBook(@PathVariable(value = "bookId")Long bookId){
        return bookService.getOneBook(bookId);
    }


//UPDATE ONE BOOK
    @PutMapping("/book/{bookId}/")
    public Book updateBook(@PathVariable(value = "bookId")Long bookId,
                           @RequestBody Book bookObj){
        return bookService.updateBook(bookId, bookObj);
    }



//delete one book
    @DeleteMapping("/book/{bookId}/")
    public Optional<Book> deleteBook(@PathVariable (value = "bookId") Long bookId) {

        return bookService.deleteBook(bookId);
    }













}
