package com.example.javabookstoremanagement.configuration;

import com.example.javabookstore.domain.author.AuthorRepository;
import com.example.javabookstore.domain.book.BookRepository;
import com.example.javabookstoremanagement.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfiguration {

    @Bean
    public BookService bookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        return new BookService(bookRepository, authorRepository);
    }
}
