-- liquibase formatted sql

-- changeset author:1
-- Создаём ENUM тип для ролей пользователя
CREATE TYPE user_role_enum AS ENUM ('ADMIN', 'BANK', 'MANAGER', 'USER', 'DRIVER');

-- changeset author:2
CREATE TABLE IF NOT EXISTS "users" (
    user_id BIGSERIAL PRIMARY KEY,
    keycloak_id UUID NOT NULL UNIQUE,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    patronymic VARCHAR(50),
    birth_date TIMESTAMPTZ NOT NULL,
    contact_id BIGINT,
    avatar_id VARCHAR(100),
    user_role user_role_enum NOT NULL DEFAULT 'USER',
    is_blocked BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ,

    CONSTRAINT fk_user_contact FOREIGN KEY (contact_id) REFERENCES contacts(id)
);

-- changeset author:3
CREATE INDEX idx_user_keycloak_id ON "users"(keycloak_id);
CREATE INDEX idx_user_contact_id ON "users"(contact_id);
CREATE INDEX idx_user_user_role ON "users"(user_role);
