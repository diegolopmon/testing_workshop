package com.example.javabookstore.book;

import com.example.javabookstore.domain.book.Book;
import com.example.javabookstore.utils.BookMother;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTests {

    private static BookMother bookMother = new BookMother();

    /**
     * Anemic test!
     */
    @Test
    void givenABookWhenNameIsHamletThenReturnNameHamlet() {
        Book hamlet = bookMother.getHamlet();
        assertEquals("Hamlet", hamlet.getName());
    }

    /**
     * Anemic test!
     */
    @Test
    void givenABookWhenNameIsRomeoAndJulietThenReturnNameRomeoAndJuliet() {
        Book hamlet = Mockito.mock(Book.class);
        Mockito.when(hamlet.getName()).thenReturn("Romeo and Juliet");
        assertEquals("Romeo and Juliet", hamlet.getName());
    }
}
