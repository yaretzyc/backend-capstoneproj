package com.example.bookclub.controller;

import com.example.bookclub.model.Quote;
import com.example.bookclub.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/quote")
public class QuoteController {

    @Autowired
    public QuoteService quoteService;


    //get hello world
    @GetMapping(path = "/hello-world/")
    public String getHelloWorld(){
        return "hello world";
    }



    //CREATE
    @PostMapping("")
    public Quote createQuote (@RequestBody Quote quoteObj){
        return quoteService.createQuote(quoteObj);
    }
    //GET ALL Quote
    @GetMapping("/quotes/")
    public List<Quote> getQuoteList(){
        return quoteService.getQuoteList();
    }

    //GET ONE Quote
    @GetMapping("/{quoteId}/")
    public Optional<Quote> getOneQuote(@PathVariable(value = "quoteId")Long quoteId){
        return quoteService.getOneQuote(quoteId);
    }


    //UPDATE ONE Quote
    @PutMapping("/{quoteId}/")
    public Quote updateQuote(@PathVariable(value = "quoteId")Long quoteId,
                           @RequestBody Quote quoteObj){
        return quoteService.updateQuote(quoteId, quoteObj);
    }



    //delete one Quote
    @DeleteMapping("/{quoteId}/")
    public Optional<Quote> deleteQuote(@PathVariable (value = "quoteId") Long quoteId) {

        return quoteService.deleteQuote(quoteId);
    }



}
