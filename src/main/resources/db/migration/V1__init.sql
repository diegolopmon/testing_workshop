CREATE TABLE AUTHOR
(
    id   INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE BOOK
(
    id        INTEGER PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(255),
    pages     INTEGER,
    isbn      VARCHAR(20),
    author_id INTEGER,
    FOREIGN KEY (author_id) REFERENCES AUTHOR (id)
);

INSERT INTO AUTHOR (name) VALUES ('William Shakespeare');