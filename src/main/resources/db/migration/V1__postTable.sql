CREATE TABLE Post
(
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    createdBy VARCHAR(255) NOT NULL,
    textBody   TEXT NOT NULL,
    dateCreated TIMESTAMP NOT NULL,
    postViews INTEGER

);

CREATE TABLE siteUser
(
    id SERIAL PRIMARY KEY,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);