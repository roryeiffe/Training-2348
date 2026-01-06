-- get a clean fresh start
drop table if exists pet cascade; -- we use cascade if there are other tables/columns that depend on this table
drop table if exists person cascade;

create table if not exists person (id serial primary key, name varchar(50)); -- person table
create table if not exists pet(id serial primary key, name varchar(50), owner_id integer); -- pet table that "references" the person table

insert into person values (default, 'Shaggy'); -- id 1
insert into person values (default, 'John'); -- id 2
insert into person values (default, 'Steve'); -- id 3
insert into person values (default, 'Rory'); -- id 3
insert into person values (default, 'Bob'); -- id 3
insert into person values (default, 'Tony'); -- id 3

insert into pet values(default, 'Scooby Doo', 1); -- "Referencing" shaggy's record
insert into pet values(default, 'Scrappy Doo', 1);
insert into pet values(default, 'Garfield', 2);
insert into pet values (default, 'Odie', 2);
insert into pet values(default, 'Fluffy', null); -- null indicates that we don't have an owner

select * from person;
select * from pet;

-- inner join: (won't see any petless humans or humanless pets, every record has a match)
select person.name, pet.name
from person join pet
on pet.owner_id = person.id 
order by person.name;

-- left outer join (will include everything from the left table)
-- in the right table, we will see NULL values where there aren't any corresponding pets
select person.name, pet.name
from person left outer join pet
on pet.owner_id = person.id 
order by person.name;

-- right outer join is the opposite where we now see every record from pet table 
-- and some null values on the left side (person table)
select person.name, pet.name
from person right outer join pet
on pet.owner_id = person.id 
order by person.name;

-- full outer join:
select person.name, pet.name
from person full outer join pet
on pet.owner_id = person.id 
order by person.name;

-- self join
drop table if exists employee;
create table employee (id serial primary key, name varchar(50), department varchar(50), manager_id integer);
insert into employee values (default, 'Michael', 'manager', 1);
insert into employee values (default, 'Jim', 'manager', 1);
insert into employee values (default, 'Dwight', 'manager', 1);
insert into employee values (default, 'Ron Swanson', 'manager', 4);
insert into employee values (default, 'Leslie Knope', 'manager', 4);

select e1.name as employee_name, e2.name as manager_name
-- give each table aliases to differentiate between them:
from employee e1 join employee e2
-- e1 represents the employee and e2 represents the manager, then we're checking e1's manaer id to e2's id
on e1.manager_id = e2.id
;

-- cross join, visualizing every combination of records from each table:
select * from person cross join pet;












