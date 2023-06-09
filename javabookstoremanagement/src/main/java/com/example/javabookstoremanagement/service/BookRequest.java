package com.example.javabookstoremanagement.service;

public class BookRequest {
    protected String name;
    protected Long authorId;
    protected int pages;
    protected String isbn;
    private long price;

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
    public long getPrice() {
        return price;
    }

    private BookRequest(String name,
                        Long authorId,
                        int pages,
                        String isbn, Long price) {
        this.name = name;
        this.authorId = authorId;
        this.pages = pages;
        this.isbn = isbn;
    }



    public void setPrice(long price) {
        this.price = price;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private Long authorId;
        private int pages;
        private String isbn;
        private Long price;

        private Builder() {
        }

        public static Builder aBookRequest() {
            return new Builder();
        }


        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAuthorId(Long authorId) {
            this.authorId = authorId;
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

        public Builder withPrice(Long price) {
            this.price = price;
            return this;
        }

        public BookRequest build() {
            return new BookRequest(name, authorId, pages, isbn, price);
        }
    }
}
