package com.example.javabookstoremanagement.utils;

import com.example.javabookstore.domain.author.Author;

public class AuthorMother {
    public Author getShakespeare() {
        return Author.Builder.anAuthor()
                .withName("William Shakespeare")
                .build();
    }
}
