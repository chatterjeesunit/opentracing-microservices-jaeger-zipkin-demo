insert into customer(email_address, first_name, last_name, gender)
values
('superman@superheroes.com', 'Clark', 'Kent', 'MALE' ),
('batman@superheroes.com', 'Bruce', 'Wayne', 'MALE' ),
('spiderman@superheroes.com', 'Peter', 'Parker', 'MALE' ),
('ironman@superheroes.com', 'Tony', 'Stark', 'MALE' ),
('captainamerica@superheroes.com', 'Steve', 'Rogers', 'MALE' ),
('hulk@superheroes.com', 'Bruce', 'Banner', 'MALE' ),
('wonderwoman@superheroes.com', 'Diana', 'Prince', 'FEMALE' ),
('captainmarvel@superheroes.com', 'Carol', 'Danvers', 'FEMALE'  ),
('blackwidow@superheroes.com', 'Natasha', 'Romanoff', 'FEMALE' );


insert into address (customer_id, address_type, city, country, state_code, street_address, zip_code)
select c.id, 'BILLING', 'Metropolis', 'United States of America', 'NY', '1938 Sullivan Place', '10005'
from customer c where email_address = 'superman@superheroes.com';

insert into address (customer_id, address_type, city, country, state_code, street_address, zip_code)
select c.id, 'BILLING', 'Gotham', 'United States of America', 'NY', '1007 Mountain Drive', '10004'
from customer c where email_address = 'batman@superheroes.com';

insert into address (customer_id, address_type, city, country, state_code, street_address, zip_code)
select c.id, 'BILLING', 'Queens', 'United States of America', 'NY', '20 Ingram Street, Forest Hills', '10054'
from customer c where email_address = 'spiderman@superheroes.com';

insert into address (customer_id, address_type, city, country, state_code, street_address, zip_code)
select c.id, 'BILLING', 'Malibu', 'United States of America', 'CA', '10880 Malibu Point', '90265'
from customer c where email_address = 'ironman@superheroes.com';

insert into address (customer_id, address_type, city, country, state_code, street_address, zip_code)
select c.id, 'BILLING', 'Brooklyn', 'United States of America', 'NY', '569 Leaman Place, Brooklyn Heights ', '11201'
from customer c where email_address = 'captainamerica@superheroes.com';

insert into address (customer_id, address_type, city, country, state_code, street_address, zip_code)
select c.id, 'BILLING', 'Dayton', 'United States of America', 'OH', '-', '45377'
from customer c where email_address = 'hulk@superheroes.com';

insert into address (customer_id, address_type, city, country, state_code, street_address, zip_code)
select c.id, 'BILLING', 'Paradise Island', 'Unknown', 'UK', '-', '-'
from customer c where email_address = 'wonderwoman@superheroes.com';

insert into address (customer_id, address_type, city, country, state_code, street_address, zip_code)
select c.id, 'BILLING', 'New York', 'United States of America', 'NY', '135 W. 50th Street', '10076'
from customer c where email_address = 'captainmarvel@superheroes.com';

insert into address (customer_id, address_type, city, country, state_code, street_address, zip_code)
select c.id, 'BILLING', 'New York', 'United States of America', 'NY', '135 W. 50th Street', '10076'
from customer c where email_address = 'blackwidow@superheroes.com';