package com.example.javabookstore.domain.author;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "AUTHOR")
public class Author {
    protected String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static final class Builder {
        private Long id;
        private String name;

        private Builder() {
        }

        public static Builder anAuthor() {
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

        public Author build() {
            return new Author(id, name);
        }
    }
}
