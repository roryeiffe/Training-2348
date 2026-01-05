--create database pets;
drop table if exists pet;
drop table if exists person;

-- Create the tables: (Make sure we match our entities)
create table person(id serial primary key, name varchar(50) unique, password varchar(50));
create table pet(id serial primary key, name varchar(50), species varchar(50), food varchar(50), owner_id integer references person);

insert into person values (default, 'shelter', 'password');

insert into pet values (default, 'fluffy', 'cat', 'cat food', 1);
insert into pet values (default, 'inky', 'cat', 'cat food', 1);
insert into pet values (default, 'rufus', 'dog', 'dog food', 1);
insert into pet values(default, 'scooby', 'dog', 'scooby snacks', 1);

SELECT * FROM pet WHERE id = 1;

select * from pet;

select * from person;