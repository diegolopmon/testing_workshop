INSERT INTO author (name)
VALUES ('William Shakespeare');

INSERT INTO book (isbn, name, pages, price, author_id)
VALUES ('978-8467033380', 'Hamlet', 320, 30.99,
        (SELECT id AS author_id
         FROM author
         WHERE name = 'William Shakespeare'));
