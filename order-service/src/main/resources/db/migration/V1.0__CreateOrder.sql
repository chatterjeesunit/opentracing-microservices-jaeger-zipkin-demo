CREATE TYPE order_status_enum AS ENUM ('CREATED', 'PENDING_PAYMENT', 'CONFIRMED', 'SHIPPED', 'DELIVERED');

CREATE TABLE orders(
    id SERIAL PRIMARY KEY,
    customer_id uuid NOT NULL,
    order_date TIMESTAMP NOT NULL,
    order_status order_status_enum NOT NULL
);

CREATE INDEX idx_orders_customer_id ON orders(customer_id);
CREATE INDEX idx_orders_date ON orders(order_date);
CREATE INDEX idx_orders_status ON orders(order_status);