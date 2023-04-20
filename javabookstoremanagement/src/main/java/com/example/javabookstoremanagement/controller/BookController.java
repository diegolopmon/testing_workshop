package com.example.javabookstoremanagement.controller;

import com.example.javabookstore.domain.author.Author;
import com.example.javabookstore.domain.book.Book;
import com.example.javabookstoremanagement.service.BookRequest;
import com.example.javabookstoremanagement.service.BookService;
import com.example.javabookstoremanagement.controller.dto.AuthorDTO;
import com.example.javabookstoremanagement.controller.dto.BookDTO;
import com.example.javabookstoremanagement.controller.dto.BookRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class BookController {
    public static final String BOOK_URL = "/book";
    public static final String ISBN_QUERY_PARAM = "isbn";
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody BookRequestDTO bookRequestDTO) {
        bookService.addBook(mapBookRequest(bookRequestDTO));
    }

    @GetMapping(BOOK_URL)
    public BookDTO getBookByIsbn(
            @RequestParam(ISBN_QUERY_PARAM) String isbn
    ) {
        return mapBookDTO(bookService.getBookByIsbn(isbn));
    }

    private BookRequest mapBookRequest(BookRequestDTO bookRequestDTO) {
        return BookRequest.Builder.aBookRequest()
                .withAuthorId(bookRequestDTO.getAuthorId())
                .withIsbn(bookRequestDTO.getIsbn())
                .withName(bookRequestDTO.getName())
                .withPages(bookRequestDTO.getPages())
                .build();
    }

    private Author mapAuthorDTO(AuthorDTO author) {
        return Author.Builder.anAuthor()
                .withId(author.getId())
                .withName(author.getName())
                .build();
    }

    private BookDTO mapBookDTO(Book book) {
        return BookDTO.Builder.aBookDTO()
                .withAuthor(mapAuthor(book.getAuthor()))
                .withId(book.getId())
                .withIsbn(book.getIsbn())
                .withPages(book.getPages())
                .withName(book.getName())
                .withPrice(book.getPrice())
                .build();
    }

    private AuthorDTO mapAuthor(Author author) {
        return AuthorDTO.Builder.anAuthorDTO()
                .withId(author.getId())
                .withName(author.getName())
                .build();
    }
}
