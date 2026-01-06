drop table if exists customers;
create table customers (id serial primary key, email varchar(50));

-- creating the index:
--create index idx_customer_email on customers (email);

insert into customers values(default, 'a@gmail.com');
insert into customers values(default, 'e@gmail.com');
insert into customers values(default, 'e@gmail.com');
insert into customers values(default, 'r@gmail.com');
insert into customers values(default, 'd@gmail.com');
insert into customers values(default, 'a@gmail.com');
insert into customers values(default, 'a@gmail.com');

select * from customers where email = 'r@gmail.com';