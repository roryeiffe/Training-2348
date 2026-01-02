-- drop the table right after:
drop table if exists pet;

-- create imagine we make a mistake in spelling:
-- because we are specifying "serial" data type for id, we don't need to provide a value
-- by default, it will pick the "next" number
create table pet(id serial, pet_name varchar(50), species varchar(50), food varchar(50));

-- Insert:
insert into pet (id, pet_name, species, food) values (default, 'Gollum', 'cat', 'chicken');
-- even if we don't pass in an id at all, it should still generate:
insert into pet (pet_name, species, food) values ('Gollum', 'cat', 'chicken');
insert into pet values (default, 'scooby doo', 'dog', 'scooby snacks');



-- update data:
update pet set pet_name = 'Smeagol' where id = 2;
-- updates every record ( no where clauses)
update pet set species = 'feline';





select * from pet;

delete from pet where pet_name = 'scooby doo';

select * from pet;