package com.example.javabookstoremanagement.utils;

import com.example.javabookstore.domain.book.Book;

public class BookMother {

    private AuthorMother authorMother = new AuthorMother();

    public Book getHamlet() {
        return Book.Builder.aBook()
                .withName("Hamlet")
                .withAuthor(authorMother.getShakespeare())
                .withPages(320)
                .withIsbn("978-8467033380")
                .build();
    }
}
