-- liquibase formatted sql

-- changeset author:1-rollback
-- rollback DROP TABLE IF EXISTS "user";
-- rollback DROP TYPE IF EXISTS user_role_enum;

-- А если хочешь явный rollback:
DELETE FROM "user" WHERE user_id IS NOT NULL;
DROP TABLE IF EXISTS "user";
DROP TYPE IF EXISTS user_role_enum;