package com.example.bookclub.service;

import com.example.bookclub.exceptions.InformationNotFoundException;
import com.example.bookclub.model.Book;
import com.example.bookclub.model.Quote;
import com.example.bookclub.repository.BookRepository;
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


    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    //ALL QUOTES
    public List<Quote> allQuotes(){
        return quoteRepository.findAll();
    }


//    //create quote
//    public Quote createQuote(Quote quoteObj){
//        System.out.println("Service calling create quote method ==> ");
//        return quoteRepository.save(quoteObj);
//    }

    public Quote createQuote(Long bookId, Quote quoteObj){
        System.out.println("service calling createQuote");
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isPresent()){
            quoteObj.setBook(book.get());
            return quoteRepository.save(quoteObj);
        }else{
            throw new InformationNotFoundException("book with Id " + bookId + " not found" );
        }
    }
//
//    //get quote list
//    public List<Quote> getQuoteList(){
//        System.out.println("Service calling getQuoteList --> ");
//        return quoteRepository.findAll();
//    }
    public List<Quote> getQuoteList(Long bookId){
        System.out.println("service calling getQuoteList");
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isPresent()){
            return book.get().getQuoteList();
        }else{
            throw new InformationNotFoundException("book with Id " + bookId + " not found");
        }
    }


//
//
////get one post
//
//    public Optional<Quote> getOneQuote(Long quoteId){
//        System.out.println("Service calling getOneQuote ==>");
//        Optional<Quote> quote = quoteRepository.findById(quoteId);
//        if (quote.isPresent()){
//            return quote;
//        }else{
//            throw new InformationNotFoundException("quote with id of " + quoteId +  " not found");
//        }
//    }

    public Quote getOneQuote(Long bookId, Long quoteId){
        System.out.println("service calling getOneQuote ==> ");
//        Optional<Book> book = bookRepository.findById(bookId);
//        if (book.isPresent()){
//            for(Quote quote: book.get().getQuoteList()){
//                if(quote.getId() == quoteId){
//                    Quote quote1 = quoteRepository.findById(quoteId).get();
//                    return Optional.of(quote1);
//                }
//                throw new InformationNotFoundException("Quote with id " + quoteId + " not found");
//            }
//        }
//        throw new InformationNotFoundException("book with id " + bookId + " not found");
        Book book = bookRepository.findById(bookId).get();
        if (book == null) {
            throw new InformationNotFoundException("category with id " + bookId +
                    " not belongs to this user or category does not exist");
        }
        Optional<Quote> quote = quoteRepository.findByBookId(
                bookId).stream().filter(p -> p.getId().equals(quoteId)).findFirst();
        if (!quote.isPresent()) {
            throw new InformationNotFoundException("recipe with id " + quote +
                    " not belongs to this user or recipe does not exist");
        }
        return quote.get();


    }

//
//    //update one quote
//    public Quote updateQuote(Long quoteId, Quote quoteObj){
//        System.out.println("service calling updateQuote ==> ");
//        Optional<Quote> quote = quoteRepository.findById(quoteId);
//        if(quote.isPresent()) {
//            Quote updateQuote = quoteRepository.findById(quoteId).get();
//            updateQuote.setChapter(quoteObj.getChapter());
//            updateQuote.setQuote(quoteObj.getQuote());
//            updateQuote.setName(quoteObj.getName());
//            updateQuote.setPage(quoteObj.getPage());
//
//            return quoteRepository.save(updateQuote);
//        }
//        else {
//            throw new InformationNotFoundException("Quote with id " + quoteId + " not found");
//        }
//    }
//
    public Quote updateQuote(Long bookId, Long quoteId, Quote quoteObj){
        System.out.println("service calling updateQuote ==> ");
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isPresent()){
            for(Quote quote: book.get().getQuoteList()){
                if (quote.getId() == quoteId){
                    Quote updateQuote = quoteRepository.findById(quoteId).get();
                    updateQuote.setChapter(quoteObj.getChapter());
                    updateQuote.setQuote(quoteObj.getQuote());
                    updateQuote.setName(quoteObj.getName());
                    updateQuote.setPage(quoteObj.getPage());

                    return quoteRepository.save(updateQuote);
                }
                throw new InformationNotFoundException("Quote with Id " + quoteId + " not found");
            }
        }
        throw new InformationNotFoundException("Book with id " + bookId + " not found");
    }
//
//    //delete one quote
//    public Optional<Quote> deleteQuote(Long quoteId){
//        System.out.println("Service calling deleteQuote ==> ");
//        Optional<Quote> quote = quoteRepository.findById(quoteId);
//        if(quote.isPresent()) {
//            quoteRepository.deleteById(quoteId);
//            return quote;
//        }else{
//            throw new InformationNotFoundException("quote with id " + quoteId + " not found");
//        }
//
//    }

    public Optional<Quote> deleteQuote(Long bookId, Long quoteId){
        System.out.println("service calling deleteQuote");
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isPresent()){
            for(Quote quote: book.get().getQuoteList()){
                if(quote.getId() == quoteId){
                    Quote quote1 = quoteRepository.findById(quoteId).get();
                    quoteRepository.deleteById(quoteId);
                    return Optional.of(quote1);
                }
                throw new InformationNotFoundException("quote with id " + quoteId+ " not found");
            }
        }
        throw new InformationNotFoundException("book with Id " + bookId + " not found");
    }



}
