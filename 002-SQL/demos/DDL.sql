-- Data Definition Language

-- define the table, columns
create table if not exists pet(id integer, name varchar(50), species varchar(50), food varchar(50));

-- drop the table right after:
drop table if exists pet;

-- create imagine we make a mistake in spelling:
create table pet(id integer, pet_name varchar(50), speecies varchar(50), food varchar(50));
-- we can use alter to fix spelling:
alter table pet rename column speecies to species;
-- add/remove columns:
alter table pet add column legs integer;
alter table pet drop column legs;

drop table if exists fruits;
create table fruits (fruit_name varchar(50));

insert into fruits values ('apple');
insert into fruits values ('banana');
insert into fruits values ('lemon');
insert into fruits values ('kiwi');
select * from pet;
select * from fruits;
select fruit_name from fruits;

-- truncate remove all records from the table:
truncate fruits;

select * from fruits;