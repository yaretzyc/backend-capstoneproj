package com.example.bookclub.service;

import com.example.bookclub.exceptions.InformationNotFoundException;
import com.example.bookclub.model.Quote;
import com.example.bookclub.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuoteService {

    private QuoteRepository quoteRepository;

    @Autowired
    public void setQuoteRepository(QuoteRepository quoteRepository){
        this.quoteRepository = quoteRepository;
    }


    //create quote
    public Quote createQuote(Quote quoteObj){
        System.out.println("Service calling create quote method ==> ");
        return quoteRepository.save(quoteObj);
    }

    //get quote list
    public List<Quote> getQuoteList(){
        System.out.println("Service calling getQuoteList --> ");
        return quoteRepository.findAll();
    }


//get one post

    public Optional<Quote> getOneQuote(Long quoteId){
        System.out.println("Service calling getOneQuote ==>");
        Optional<Quote> quote = quoteRepository.findById(quoteId);
        if (quote.isPresent()){
            return quote;
        }else{
            throw new InformationNotFoundException("quote with id of " + quoteId +  " not found");
        }
    }

    //update one quote
    public Quote updateQuote(Long quoteId, Quote quoteObj){
        System.out.println("service calling updateQuote ==> ");
        Optional<Quote> quote = quoteRepository.findById(quoteId);
        if(quote.isPresent()) {
            Quote updateQuote = quoteRepository.findById(quoteId).get();
            updateQuote.setChapter(quoteObj.getChapter());
            updateQuote.setQuote(quoteObj.getQuote());
            updateQuote.setName(quoteObj.getName());
            updateQuote.setPage(quoteObj.getPage());


            return quoteRepository.save(updateQuote);
        }
        else {
            throw new InformationNotFoundException("Quote with id " + quoteId + " not found");
        }

    }


    //delete one quote
    public Optional<Quote> deleteQuote(Long quoteId){
        System.out.println("Service calling deleteQuote ==> ");
        Optional<Quote> quote = quoteRepository.findById(quoteId);
        if(quote.isPresent()) {
            quoteRepository.deleteById(quoteId);
            return quote;
        }else{
            throw new InformationNotFoundException("quote with id " + quoteId + " not found");
        }

    }



}
