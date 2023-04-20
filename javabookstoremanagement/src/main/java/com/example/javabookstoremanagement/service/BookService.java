package com.example.javabookstoremanagement.service;

import com.example.javabookstore.domain.author.Author;
import com.example.javabookstore.domain.author.AuthorRepository;
import com.example.javabookstore.domain.book.Book;
import com.example.javabookstore.domain.book.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void addBook(BookRequest bookRequest) {
        Author author = authorRepository.findById(bookRequest.authorId);
        Book book = Book.Builder.aBook()
                .withAuthor(author)
                .withPages(bookRequest.getPages())
                .withName(bookRequest.getName())
                .withIsbn(bookRequest.getIsbn())
                .withPrice(bookRequest.getPrice())
                .build();
        bookRepository.addBook(book);
    }

    public Book getBookByIsbn(String isbn) {
        return bookRepository.getBookByIsbn(isbn);
    }

}
