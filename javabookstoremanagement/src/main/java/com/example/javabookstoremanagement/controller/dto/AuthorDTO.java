package com.example.javabookstoremanagement.controller.dto;

public class AuthorDTO {
    protected String name;
    protected Long id;

    protected AuthorDTO(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }


    public static final class Builder {
        private String name;
        private Long id;

        private Builder() {
        }

        public static Builder anAuthorDTO() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public AuthorDTO build() {
            return new AuthorDTO(name, id);
        }
    }
}
