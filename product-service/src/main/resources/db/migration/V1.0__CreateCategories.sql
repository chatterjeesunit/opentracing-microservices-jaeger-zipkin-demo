CREATE TABLE categories(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

CREATE INDEX idx_categories_name ON categories(name);