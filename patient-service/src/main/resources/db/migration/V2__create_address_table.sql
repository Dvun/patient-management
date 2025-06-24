CREATE TABLE IF NOT EXISTS address
(
    id UUID PRIMARY KEY,
    street VARCHAR(255),
    city VARCHAR(255),
    country VARCHAR(255),
    phone VARCHAR(10),
    postal_code CHAR(5) NOT NULL,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated TIMESTAMP
    );


-- 1. добавляем колонку
ALTER TABLE patient
    ADD COLUMN IF NOT EXISTS address_id UUID;

-- 2. внешний ключ
ALTER TABLE patient
    ADD CONSTRAINT IF NOT EXISTS fk_patient_address
    FOREIGN KEY (address_id) REFERENCES address(id)
    ON DELETE CASCADE;

-- 3. уникальное ограничение, чтобы было one-to-one
ALTER TABLE patient
    ADD CONSTRAINT IF NOT EXISTS uq_patient_address
    UNIQUE (address_id);