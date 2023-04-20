package com.example.javabookstoremanagement.controller;

import com.example.javabookstore.domain.book.Book;
import com.example.javabookstoremanagement.service.BookService;
import com.example.javabookstoremanagement.IntegrationTest;
import com.example.javabookstoremanagement.utils.BookMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class BookControllerIntegrationTest extends IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @SpyBean
    private BookService bookService;

    private BookMother bookMother = new BookMother();

    @Test
    @Sql({"/db/fixtures/test_books_schema.sql"})
    void givenBookControllerThenReturnHamletWhenGetBooks() throws Exception {
        Book hamlet = bookMother.getHamlet();
        String isbn = hamlet.getIsbn();

        mockMvc.perform(get("/book").queryParam(BookController.ISBN_QUERY_PARAM, isbn))
                .andExpect(status().isOk())
                .andExpect(content()
                        .json("{\"name\":\"Hamlet\"," +
                                "\"author\":{\"name\":\"William Shakespeare\"}" +
                                ",\"pages\":320,\"isbn\":\"978-8467033380\"}"));
    }

    @Test
    @Sql({"/db/fixtures/test_books_schema.sql"})
    void givenBookControllerThenAddRomeoAndJulietBookWhenAddBook() throws Exception {
        String addBookRequest = readFileToString("request/add-book-request.json");

        mockMvc.perform(post("/book").content(addBookRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}