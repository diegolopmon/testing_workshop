package com.example.javabookstore.domain.author;

import com.example.javabookstore.infrastrucure.repository.author.AuthorJpaRepository;

public class AuthorRepository {
    private AuthorJpaRepository authorJpaRepository;

    public AuthorRepository(AuthorJpaRepository authorJpaRepository) {
        this.authorJpaRepository = authorJpaRepository;
    }

    public Author findById(Long id) {
        return authorJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }
}
