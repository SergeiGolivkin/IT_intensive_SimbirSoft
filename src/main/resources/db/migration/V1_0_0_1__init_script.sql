CREATE SEQUENCE IF NOT EXISTS hibernate_sequence start 1000 increment 1;



CREATE TABLE  Publisher (
    id         serial PRIMARY KEY ,
    firstName varchar(255) NOT NULL,
    lastName varchar(255) NOT NULL,
    company varchar(255) NOT NULL
);


CREATE TABLE  Author
(
    id         serial PRIMARY KEY,
    publisherId    integer ,
    firstName    varchar(255) NOT NULL,
    lastName    varchar(255) NOT NULL,
    FOREIGN KEY (publisherId) REFERENCES Publisher (id)
);

CREATE TABLE  Book
(
    id        serial PRIMARY KEY,
    authorId    integer ,
    name    varchar(255) NOT NULL,
    genre varchar(255) NOT NULL,
    yearOfPublishing integer ,
    FOREIGN KEY (authorId) REFERENCES Author (id)
);