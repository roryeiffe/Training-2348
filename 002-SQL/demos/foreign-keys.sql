-- setting up a relationship between people and pets:
drop table if exists pet cascade;
drop table if exists person cascade;
drop table if exists food cascade;
drop table if exists pet_food_lookup_table cascade;

-- 1 to many relationship (1 person to many pets)
-- note that the "1" side of the relationship does not include the "references" clause
create table person (id serial primary key, person_name varchar(50));

-- owner_id field depends on the person table, should target the id field automatically (Primary Key) but we can also explicitly define it:
create table pet (id serial primary key, pet_name varchar(50), owner_id integer references person(id) );

insert into person values (default, 'shelter');
insert into person values (default, 'shaggy');
insert into person values (default, 'john');

select * from person;

insert into pet values(default, 'scooby', 2);
insert into pet values(default, 'scrappy', 2);
insert into pet values(default, 'garfield', 3);
insert into pet values(default, 'odie', 3);
insert into pet values(default, 'clifford', 1);
-- if we try to insert a value to pets with an invalid person_id (an id that doesn't exist in person table), then we will get an error:
--insert into pet values(default, 'Blue', 5);

select * from pet;

-- many to many relationship:
-- Still using our pet table, we just need to create a food table and then a lookup table to connect to the two
create table food (id serial primary key, food_name varchar(50));
insert into food (food_name) values ('scooby snacks');
insert into food (food_name) values ('lasagna');
insert into food (food_name) values ('pizza');
insert into food (food_name) values ('dog food');

select * from food;

create table pet_food_lookup_table(pet_id integer references pet, food_id integer references food);

-- a record of (1,1) means that the pet with id 1 likes food with id 1
insert into pet_food_lookup_table values (1, 1);
insert into pet_food_lookup_table values (1, 2);
insert into pet_food_lookup_table values (1, 3);
insert into pet_food_lookup_table values (1, 4);
insert into pet_food_lookup_table values (2, 1);
insert into pet_food_lookup_table values (2, 4);
insert into pet_food_lookup_table values (3, 2);
insert into pet_food_lookup_table values (4, 4);

select * from pet_food_lookup_table ;





