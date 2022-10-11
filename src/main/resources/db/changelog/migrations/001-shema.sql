create schema shop;

set schema 'shop';

create TABLE CUSTOMERS
(id SERIAL PRIMARY KEY,
 name VARCHAR(100) not null,
 surname VARCHAR(100) not null,
 age int,
 phone_number int);

create TABLE ORDERS
(id SERIAL PRIMARY KEY,
 date TIMESTAMP not null,
 customer_id int not null,
 product_name VARCHAR,
 amount DECIMAL,
 FOREIGN KEY (customer_id) REFERENCES customers (id));
