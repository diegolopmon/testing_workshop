package com.example.javabookstoremanagement.service;

public class BookRequest {
    protected String name;
    protected Long authorId;
    protected int pages;
    protected String isbn;

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

    private BookRequest(String name,
                        Long authorId,
                        int pages,
                        String isbn) {
        this.name = name;
        this.authorId = authorId;
        this.pages = pages;
        this.isbn = isbn;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private Long authorId;
        private int pages;
        private String isbn;

        private Builder() {
        }

        public static BookRequest.Builder aBookRequest() {
            return new BookRequest.Builder();
        }


        public BookRequest.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public BookRequest.Builder withAuthorId(Long authorId) {
            this.authorId = authorId;
            return this;
        }

        public BookRequest.Builder withPages(int pages) {
            this.pages = pages;
            return this;
        }

        public BookRequest.Builder withIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public BookRequest build() {
            return new BookRequest(name, authorId, pages, isbn);
        }
    }
}
