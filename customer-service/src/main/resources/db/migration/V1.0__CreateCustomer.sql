drop table if exists customer;
CREATE TABLE customer (
  id bigserial NOT NULL PRIMARY KEY ,
  email_address varchar(255) UNIQUE NOT NULL,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL
);

CREATE INDEX idx_customer_fname ON customer(first_name);
CREATE INDEX idx_customer_lname ON customer(last_name);