package com.example.javabookstore.domain.book;

import com.example.javabookstore.domain.author.Author;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "BOOK")
public class Book {
    protected String name;
    @OneToOne(fetch = FetchType.LAZY)
    protected Author author;
    protected int pages;
    protected String isbn;
    protected double price;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    public Book() {

    }

    public Book(Long id,
                String name,
                Author author,
                int pages,
                String isbn,
                double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.isbn = isbn;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private Author author;
        private int pages;
        private String isbn;
        private double price;

        private Builder() {
        }

        public static Builder aBook() {
            return new Builder();
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAuthor(Author author) {
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

        public Builder withPrice(long price) {
            this.price = price;
            return this;
        }

        public Book build() {
            return new Book(id, name, author, pages, isbn, price);
        }
    }
}
