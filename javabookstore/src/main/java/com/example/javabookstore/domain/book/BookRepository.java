package com.example.javabookstore.domain.book;

import com.example.javabookstore.infrastrucure.repository.book.BookJpaRepository;

public class BookRepository {
    private BookJpaRepository bookJpaRepository;

    public BookRepository(BookJpaRepository bookJpaRepository) {
        this.bookJpaRepository = bookJpaRepository;
    }

    public void addBook(Book book) {
        bookJpaRepository.save(book);
    }

    public Book getBookByIsbn(String isbn) {
        return bookJpaRepository.findByIsbn(isbn);
    }
}
