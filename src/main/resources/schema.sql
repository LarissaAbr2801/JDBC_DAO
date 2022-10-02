create schema shop;

create TABLE CUSTOMERS
(id SERIAL PRIMARY KEY,
 name VARCHAR(100) not null,
 surname VARCHAR(100) not null,
 age int,
 phone_number int);


insert into customers(id, name,surname ,age,phone_number)
values (111, 'Ivan', 'Cdf', 12, 2345);

create TABLE ORDERS
(id SERIAL PRIMARY KEY,
 date TIMESTAMP not null,
 customer_id int not null,
 product_name VARCHAR,
 amount DECIMAL,
 FOREIGN KEY (customer_id) REFERENCES customers (id));

insert into orders(id, date,customer_id  ,product_name ,amount )
values (1, '2020-03-23 00:00', 111, 'product', 23)
