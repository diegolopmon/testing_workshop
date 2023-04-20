package com.example.javabookstore.infrastrucure.repository.author;

import com.example.javabookstore.domain.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorJpaRepository extends JpaRepository<Author, Long> {
    Optional<Author> findById(Long id);
}
