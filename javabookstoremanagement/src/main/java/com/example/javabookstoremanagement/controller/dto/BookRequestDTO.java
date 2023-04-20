package com.example.javabookstoremanagement.controller.dto;

public class BookRequestDTO {
    private String name;
    private Long authorId;
    private int pages;
    private String isbn;
    private Long price;

    public BookRequestDTO(String name, Long authorId, int pages, String isbn, Long price) {
        this.name = name;
        this.authorId = authorId;
        this.pages = pages;
        this.isbn = isbn;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public int getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public Long getPrice() {
        return price;
    }
}
