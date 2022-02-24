package com.example.bookclub.service;

import com.example.bookclub.model.Book;
import com.example.bookclub.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
//create book
    public Book createBook(Book bookObj){
        System.out.println("Service calling create book method ==> ");
//        Book book = bookRepository.
        return bookRepository.save(bookObj);
    }
//get book list
    public List<Book> getBookList(){
        System.out.println("Service calling getBookList --> ");
        return bookRepository.findAll();
    }


//get one book

    public Optional<Book> getOneBook(Long bookId){
        System.out.println("Service calling getOneBook ==>");
        return bookRepository.findById(bookId);
        //        Optional<Book> book = bookRepository.findById(bookId);
        //        if (book.isPresent()){
        //            return book;
        //        }else{
        //            throw new InformationNotFoundException("book with id of " + researcherId +  " not found");
        //        }
    }

//update one book
    public Book updateBook(Long bookId, Book bookObj){
        System.out.println("service calling updateBook ==> ");
        Book updateBook = bookRepository.findById(bookId).get();
        updateBook.setAuthor(bookObj.getAuthor());
        updateBook.setGenre(bookObj.getGenre());
        updateBook.setImg(bookObj.getImg());
        updateBook.setLink(bookObj.getLink());
        updateBook.setPages(bookObj.getPages());
        updateBook.setTitle(bookObj.getTitle());
        updateBook.setSummary(bookObj.getSummary());
        updateBook.setOther(bookObj.getOther());
        return bookRepository.save(updateBook);
        //        Optional<Book> updateBook = bookRepository.findById(bookId);
        //        if(updateBook.isPresent()) {
        //            updateBook.setAuthor(bookObj.getAuthor());
        //            updateBook
        //            return bookRepository.save(bookObj);
        //        }
    }


//delete one book
    public Book deleteBook(Long bookId){
        return bookRepository.deleteById(bookId);

//        Optional<Researcher> researcher = researcherRepository.findById(researcherId);
//        if(researcher.isPresent()) {
//            researcherRepository.deleteById(researcherId);
//            return researcher;

        }
}







}
