insert into customer(id, email_address, first_name, last_name, gender)
values
(1, 'superman@superheroes.com', 'Clark', 'Kent', 'MALE', '5c09f060-f062-11ea-9298-0242c0a88003' ),
(2, 'batman@superheroes.com', 'Bruce', 'Wayne', 'MALE', '5c0e737e-f062-11ea-9298-0242c0a88003'),
(3, 'spiderman@superheroes.com', 'Peter', 'Parker', 'MALE', '5c0e7644-f062-11ea-9298-0242c0a88003' ),
(4, 'ironman@superheroes.com', 'Tony', 'Stark', 'MALE', '5c0e7932-f062-11ea-9298-0242c0a88003' ),
(5, 'captainamerica@superheroes.com', 'Steve', 'Rogers', 'MALE', '5c0e7b44-f062-11ea-9298-0242c0a88003' ),
(6, 'hulk@superheroes.com', 'Bruce', 'Banner', 'MALE', '5c0e7c7a-f062-11ea-9298-0242c0a88003' ),
(7, 'wonderwoman@superheroes.com', 'Diana', 'Prince', 'FEMALE', '5c0e7d2e-f062-11ea-9298-0242c0a88003' ),
(8, 'captainmarvel@superheroes.com', 'Carol', 'Danvers', 'FEMALE', '5c0e7e5a-f062-11ea-9298-0242c0a88003' ),
(9, 'blackwidow@superheroes.com', 'Natasha', 'Romanoff', 'FEMALE', '5c0e7fe0-f062-11ea-9298-0242c0a88003' );


insert into address (customer_id, address_type, city, country, state_code, street_address, zip_code)
values
(1, 'BILLING', 'Metropolis', 'United States of America', 'NY', '1938 Sullivan Place', '10005'),
(2, 'BILLING', 'Gotham', 'United States of America', 'NY', '1007 Mountain Drive', '10004'),
(3, 'BILLING', 'Queens', 'United States of America', 'NY', '20 Ingram Street, Forest Hills', '10054'),
(4, 'BILLING', 'Malibu', 'United States of America', 'CA', '10880 Malibu Point', '90265'),
(5, 'BILLING', 'Brooklyn', 'United States of America', 'NY', '569 Leaman Place, Brooklyn Heights ', '11201'),
(6, 'BILLING', 'Dayton', 'United States of America', 'OH', '-', '45377'),
(7, 'BILLING', 'Paradise Island', 'Unknown', 'UK', '-', '-'),
(8, 'BILLING', 'New York', 'United States of America', 'NY', '135 W. 50th Street', '10076'),
(9, 'BILLING', 'New York', 'United States of America', 'NY', '135 W. 50th Street', '10076');
