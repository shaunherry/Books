package com.shaun.mybooks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaun.mybooks.models.Book;
import com.shaun.mybooks.repos.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
	
@Autowired    
    
	private BookRepository bookRepository;
    
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}