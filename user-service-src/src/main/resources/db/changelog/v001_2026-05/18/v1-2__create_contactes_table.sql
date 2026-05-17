-- liquibase formatted sql

-- changeset author:3
CREATE TABLE IF NOT EXISTS contacts (
    id BIGSERIAL PRIMARY KEY,
    phone VARCHAR(20) UNIQUE,
    email VARCHAR(50) UNIQUE,
    telegram VARCHAR(50) UNIQUE,
    whatsapp VARCHAR(50) UNIQUE,
    other VARCHAR(100),
    address_id BIGINT,

    CONSTRAINT fk_contact_address FOREIGN KEY (address_id) REFERENCES address(id)
);

-- changeset author:4
CREATE INDEX idx_contacts_phone ON contacts(phone);
CREATE INDEX idx_contacts_email ON contacts(email);
CREATE INDEX idx_contacts_address_id ON contacts(address_id);
