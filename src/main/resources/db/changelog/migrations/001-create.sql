<<<<<<< HEAD:src/main/resources/db/changelog/migrations/001-create.sql
=======
create schema shop;

set schema 'shop';

>>>>>>> main:src/main/resources/schema.sql
create TABLE CUSTOMERS
(id SERIAL PRIMARY KEY,
 name VARCHAR(100) not null,
 surname VARCHAR(100) not null,
 age int,
 phone_number int);

<<<<<<< HEAD:src/main/resources/db/changelog/migrations/001-create.sql
=======

insert into customers(id, name,surname ,age,phone_number)
values (111, 'Ivan', 'Cdf', 12, 2345);
insert into customers(id, name,surname ,age,phone_number)
values (22, 'Ivan', 'Cdf', 23, 45);

>>>>>>> main:src/main/resources/schema.sql
create TABLE ORDERS
(id SERIAL PRIMARY KEY,
 date TIMESTAMP not null,
 customer_id int not null,
 product_name VARCHAR,
 amount DECIMAL,
 FOREIGN KEY (customer_id) REFERENCES customers (id));
<<<<<<< HEAD:src/main/resources/db/changelog/migrations/001-create.sql
=======

insert into orders(id, date,customer_id  ,product_name ,amount )
values (1, '2020-03-23 00:00', 111, 'product', 23);
insert into orders(id, date,customer_id  ,product_name ,amount )
values (2, '2020-03-23 00:00', 22, 'car', 23);

>>>>>>> main:src/main/resources/schema.sql
