CREATE TABLE products (
  id bigserial NOT NULL PRIMARY KEY ,
  name VARCHAR(255) UNIQUE NOT NULL,
  price NUMERIC NOT NULL,
  ratings NUMERIC NULL,
  brand VARCHAR(255) NOT NULL,
  category_id INT NOT NULL,
  product_guid uuid UNIQUE NOT NULL DEFAULT uuid_generate_v1 (),
  FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE INDEX idx_products_name ON products(name);
CREATE INDEX idx_products_guid ON products(product_guid);
