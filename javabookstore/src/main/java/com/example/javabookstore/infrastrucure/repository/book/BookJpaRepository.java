package com.example.javabookstore.infrastrucure.repository.book;

import com.example.javabookstore.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
    Book findByIsbn(String isbn);

}
