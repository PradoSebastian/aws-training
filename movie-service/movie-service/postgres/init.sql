-- Create customer db

CREATE DATABASE customer;
CREATE USER customer_user WITH PASSWORD 'customer_password';

\connect customer;

CREATE TABLE customer (
   id UUID PRIMARY KEY,
   name VARCHAR(255),
   favorite_genre VARCHAR(100)
);

INSERT INTO customer (id, name, favorite_genre)
VALUES
    ('f04592a6-4fc6-4720-b2e4-fed6ab194c1c', 'sam', 'ACTION'),
    ('d2a5110a-1aca-4e79-8332-9b43270ffb8b', 'sara', 'CRIME');

 GRANT ALL PRIVILEGES ON ALL TABLES in SCHEMA public TO customer_user;

-- Create movie db

 CREATE DATABASE movie;
 CREATE USER movie_user WITH PASSWORD 'movie_password';

\connect movie;

 CREATE TABLE movie (
    id UUID PRIMARY KEY,
    title VARCHAR(255),
    release_year INTEGER,
    genre VARCHAR(100)
 );

INSERT INTO movie (id, title, release_year, genre)
VALUES
    ('b04592a6-4fc6-4720-b2e4-fed6ab194c1c', 'Inception', 2010, 'ACTION'),
    ('f2a5110a-1aca-4e79-8332-9b43270ffb8b', 'The Godfather', 1972, 'CRIME'),
    ('53041a8e-399a-4051-abc8-b95223096bd3', 'Mad Max: Fury Road', 2015, 'ACTION'),
    ('81b8f12e-8422-4d8e-b6ee-149a0c555bcf', 'Die Hard', 1988, 'ACTION'),
    ('0aa89b6b-601a-4748-913f-577ea68fb972', 'Pulp Fiction', 1994, 'CRIME'),
    ('9b39715c-a7bf-4333-b0b8-b58de7cb85f1', 'Superbad', 2007, 'COMEDY');

 GRANT ALL PRIVILEGES ON ALL TABLES in SCHEMA public TO movie_user;