CREATE TYPE gender_enum AS ENUM ('MALE', 'FEMALE', 'OTHER');

CREATE TABLE customer (
  id bigserial NOT NULL PRIMARY KEY ,
  email_address VARCHAR(255) UNIQUE NOT NULL,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  gender gender_enum NOT NULL,
  customer_guid uuid UNIQUE NOT NULL DEFAULT uuid_generate_v1 ()
);

CREATE INDEX idx_customer_fname ON customer(first_name);
CREATE INDEX idx_customer_lname ON customer(last_name);
CREATE INDEX idx_customer_guid ON customer(customer_guid);
