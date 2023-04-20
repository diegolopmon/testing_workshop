package com.example.javabookstoremanagement.controller;

import com.example.javabookstore.domain.book.Book;
import com.example.javabookstoremanagement.service.BookService;
import com.example.javabookstoremanagement.utils.BookMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerComponentTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    private BookMother bookMother = new BookMother();

    @Test
    void givenBookControllerThenReturnHamletWhenGetBooks() throws Exception {
        Book hamlet = bookMother.getHamlet();
        String isbn = hamlet.getIsbn();

        when(bookService.getBookByIsbn(isbn)).thenReturn(hamlet);

        mockMvc.perform(get(BookController.BOOK_URL).queryParam(BookController.ISBN_QUERY_PARAM, isbn))
                .andExpect(status().isOk())
                .andExpect(content()
                        .json("{\"name\":\"Hamlet\"," +
                                "\"author\":{\"name\":\"William Shakespeare\"}" +
                                ",\"pages\":320,\"isbn\":\"978-8467033380\"}"))
                .andExpect(jsonPath("$.*", hasSize(6)));
    }
}