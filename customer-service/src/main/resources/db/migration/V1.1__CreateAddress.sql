drop table if exists address;

CREATE TYPE address_type_enum AS ENUM ('BILLING', 'SHIPPING', 'HOME', 'OTHER');

CREATE TABLE address (
  id SERIAL NOT NULL PRIMARY KEY,
  customer_id bigint,
  address_type address_type_enum NOT NULL,
  city varchar(255) NOT NULL,
  country varchar(255) NOT NULL,
  state_code varchar(255) NOT NULL,
  street_address varchar(255) DEFAULT NULL,
  zip_code varchar(255) NOT NULL,
  FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE INDEX idx_address_customer_id on address(customer_id);