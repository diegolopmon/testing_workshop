package com.example.javabookstoremanagement.controller.dto;

public class BookDTO {

    protected String name;
    protected AuthorDTO author;
    protected int pages;
    protected String isbn;
    protected Long id;
    private final double price;

    protected BookDTO(String name, AuthorDTO author, int pages, String isbn, Long id, double price) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.isbn = isbn;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public static final class Builder {
        private String name;
        private AuthorDTO author;
        private int pages;
        private String isbn;
        private Long id;
        private double price;

        private Builder() {
        }

        public static Builder aBookDTO() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAuthor(AuthorDTO author) {
            this.author = author;
            return this;
        }

        public Builder withPages(int pages) {
            this.pages = pages;
            return this;
        }

        public Builder withIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withPrice(double price) {
            this.price = price;
            return this;
        }

        public BookDTO build() {
            return new BookDTO(name, author, pages, isbn, id, price);
        }

    }
}
