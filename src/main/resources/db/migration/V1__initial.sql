CREATE TABLE users (
    id INT GENERATED ALWAYS AS IDENTITY,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);