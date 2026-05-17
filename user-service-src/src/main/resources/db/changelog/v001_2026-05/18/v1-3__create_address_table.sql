-- liquibase formatted sql

-- changeset author:5
CREATE TABLE IF NOT EXISTS address (
    id BIGSERIAL PRIMARY KEY,
    country VARCHAR(50),
    zip_code VARCHAR(10),
    city VARCHAR(50),
    street VARCHAR(50),
    house INTEGER,
    block VARCHAR(50)
);
