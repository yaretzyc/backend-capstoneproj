package com.example.bookclub.controller;

import com.example.bookclub.model.Quote;
import com.example.bookclub.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
public class QuoteController {

    @Autowired
    public QuoteService quoteService;


    //get hello world
//    @GetMapping(path = "/hello-world/")
//    public String getHelloWorld(){
//        return "hello world";
//    }
//

    //getALL QUOTES
    @GetMapping("/quotes/")
    public List<Quote> allQuotes(){
        return quoteService.allQuotes();
    }

    //CREATE
//    @PostMapping("/quote/")
//    public Quote createQuote (@RequestBody Quote quoteObj){
//        return quoteService.createQuote(quoteObj);
//    }
    @PostMapping("/book/{bookId}/quote/")
    public Quote createQuote(@PathVariable(value = "bookId")Long bookId,
                             @RequestBody Quote quoteObj){
        System.out.println("calling createQuote");
        return quoteService.createQuote(bookId, quoteObj);
    }

//    //GET ALL Quote
//    @GetMapping("/quotes/")
//    public List<Quote> getQuoteList(){
//        return quoteService.getQuoteList();
//    }
    @GetMapping("/book/{bookId}/quotes")
    public List<Quote> getQuoteList(@PathVariable(value = "bookId")Long bookId){
        return quoteService.getQuoteList(bookId);
    }
//
//    //GET ONE Quote
//    @GetMapping("/quote/{quoteId}/")
//    public Optional<Quote> getOneQuote(@PathVariable(value = "quoteId")Long quoteId){
//        return quoteService.getOneQuote(quoteId);
//    }
    @GetMapping("/book/{bookId}/quote/{quoteId}/")
    public Quote getOneQuote(@PathVariable(value = "bookId")Long bookId,
                                       @PathVariable(value = "quoteId")Long quoteId){
        return quoteService.getOneQuote(bookId, quoteId);
    }
//
//
//    //UPDATE ONE Quote
//    @PutMapping("/quote/{quoteId}/")
//    public Quote updateQuote(@PathVariable(value = "quoteId")Long quoteId,
//                           @RequestBody Quote quoteObj){
//        return quoteService.updateQuote(quoteId, quoteObj);
//    }
    @PutMapping("/book/{bookId}/quote/{quoteId}/")
    public Quote updateQuote(@PathVariable(value = "bookId")Long bookId,
                           @PathVariable(value = "quoteId")Long quoteId,
                           @RequestBody Quote quoteObj){
        return quoteService.updateQuote(bookId, quoteId, quoteObj);
    }
//
//
//
//    //delete one Quote
//    @DeleteMapping("/quote/{quoteId}/")
//    public Optional<Quote> deleteQuote(@PathVariable (value = "quoteId") Long quoteId) {
//
//        return quoteService.deleteQuote(quoteId);
//    }

    @DeleteMapping("/book/{bookId}/quote/{quoteId}/")
    public Optional<Quote> deletePost(@PathVariable(value = "bookId")Long bookId,
                                     @PathVariable(value = "quoteId")Long quoteId){
        return quoteService.deleteQuote(bookId, quoteId);
    }


}
