
insert into orders(id, customer_id, order_date, order_status)
values
(1, '5c0e7fe0-f062-11ea-9298-0242c0a88003', current_timestamp, 'CONFIRMED'),
(2, '5c0e7fe0-f062-11ea-9298-0242c0a88003', current_timestamp, 'CONFIRMED');

insert into order_items(order_id, product_id, quantity, unit_price)
values
(1, '766983d0-f062-11ea-8622-0242c0a88003', 2, 38730),
(1, '76698b78-f062-11ea-8622-0242c0a88003', 3, 186663),
(1, '76698876-f062-11ea-8622-0242c0a88003', 4, 66550),
(2, '7665d212-f062-11ea-8622-0242c0a88003', 10, 29990),
(2, '766989f2-f062-11ea-8622-0242c0a88003', 6, 59999);