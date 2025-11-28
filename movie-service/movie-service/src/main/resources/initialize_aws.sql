-- Create customer db

CREATE DATABASE customer;
CREATE USER customer_user WITH PASSWORD 'customer_password_123';

\connect customer;

CREATE TABLE customer (
   id UUID PRIMARY KEY,
   name VARCHAR(255),
   favorite_genre VARCHAR(100)
);

INSERT INTO customer (id, name, favorite_genre)
VALUES
    ('12e8f7b9-5f0e-4ff6-afbb-b3e181e546c8', 'Sam', 'ACTION'),
    ('579521b7-0b95-49f6-9ef5-d4e6a3363b3c', 'Sara', 'COMEDY');

 GRANT ALL PRIVILEGES ON ALL TABLES in SCHEMA public TO customer_user;

-- Create movie db

 CREATE DATABASE movie;
 CREATE USER movie_user WITH PASSWORD 'movie_password_123';

\connect movie;

 CREATE TABLE movie (
    id UUID PRIMARY KEY,
    title VARCHAR(255),
    release_year INTEGER,
    genre VARCHAR(100)
 );

INSERT INTO movie (id, title, release_year, genre)
VALUES
    ('9cff6199-4f48-4423-849f-82ddbd3acecb', 'Inception', 2010, 'ACTION'),
    ('d6354fab-94e4-4d23-bfd0-e84dd7326039', 'The Godfather', 1972, 'CRIME'),
    ('55f0458f-7e5c-4349-aeec-d9d69ef65965', 'Monty Python and the Holy Grail', 1975, 'COMEDY'),
    ('50523c6f-3694-4797-be08-ba15394e251e', 'The Shawshank Redemption', 1994, 'DRAMA'),
    ('86d5d51f-61ea-4a31-8d22-60f4a4a81e9f', 'Mad Max: Fury Road', 2015, 'ACTION'),
    ('e30b9d7a-2c53-4ae1-97a2-942ad6489734', 'Die Hard', 1988, 'ACTION'),
    ('3a952c63-e959-41d6-a3cf-0e629fdc7f47', 'Pulp Fiction', 1994, 'CRIME'),
    ('26ec2fb9-7deb-4a1e-9185-4571fa2a9036', 'Superbad', 2007, 'COMEDY'),
    ('0a6140de-ef7a-4197-ae17-cad501731940', 'Forrest Gump', 1994, 'DRAMA'),
    ('59b4965d-4a93-4e01-9717-f5cdd2e22cf4', 'Gladiator', 2000, 'ACTION'),
    ('08b9a452-f688-4a30-a6e2-0d61ae2d33fa', 'The Dark Knight', 2008, 'ACTION'),
    ('306cd121-f583-453e-8e07-e26d679d0790', 'Goodfellas', 1990, 'CRIME'),
    ('9617159e-f928-4d9c-8592-6cc4de1650b5', 'Anchorman: The Legend of Ron Burgundy', 2004, 'COMEDY'),
    ('c7db3b7f-f009-4f24-afcd-16ec716b7673', 'Fight Club', 1999, 'DRAMA'),
    ('b205b230-176b-4b0f-884a-2fc71fe2fd45', 'The Matrix', 1999, 'ACTION'),
    ('4dc814ab-c2ab-43cb-897b-b65089348e23', 'Scarface', 1983, 'CRIME'),
    ('33704839-d51b-4ce7-95f0-10c798a56b2b', 'Step Brothers', 2008, 'COMEDY'),
    ('b9204995-cf1e-44bb-863d-2ab20a2096c1', 'Schindler''s List', 1993, 'DRAMA'),
    ('5282182d-2978-4660-9610-4f154cd8f190', 'The Avengers', 2012, 'ACTION'),
    ('517e07be-c1a5-4639-aca9-b4f863c6a040', 'The Departed', 2006, 'CRIME');

 GRANT ALL PRIVILEGES ON ALL TABLES in SCHEMA public TO movie_user;