drop table if exists person cascade;

create table person (id serial primary key, person_name varchar(50) check (person_name like 'm%'), age integer check (age >= 18));

insert into person values (default, 'steve', 22);

insert into person values (default, 'mike', 19);

select * from person;

-- add a column for birthday and add a default value (this will be applied to previous records)
alter table person add column bday date default '1980-01-01';
insert into person (person_name, age) values ('marty', 20);

select * from person;



