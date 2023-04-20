package com.example.javabookstoremanagement.configuration;

import com.example.javabookstore.domain.author.AuthorRepository;
import com.example.javabookstore.domain.book.BookRepository;
import com.example.javabookstore.infrastrucure.repository.author.AuthorJpaRepository;
import com.example.javabookstore.infrastrucure.repository.book.BookJpaRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.javabookstore.infrastrucure.repository")
@EntityScan("com.example.javabookstore.domain")
public class RepositoryConfiguration {

    @Bean
    public BookRepository bookRepository(BookJpaRepository bookJpaRepository) {
        return new BookRepository(bookJpaRepository);
    }

    @Bean
    public AuthorRepository authorRepository(AuthorJpaRepository authorJpaRepository) {
        return new AuthorRepository(authorJpaRepository);
    }
}
