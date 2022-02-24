package com.example.bookclub.service;

import com.example.bookclub.model.Book;
import com.example.bookclub.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book bookObj){
        System.out.println("Service calling create book method ==> ");
//        Book book = bookRepository.
        return bookRepository.save(bookObj);
    }

    public List<Book> getBookList(){
        System.out.println("Service calling getBookList --> ");
        return bookRepository.findAll();
    }




}
