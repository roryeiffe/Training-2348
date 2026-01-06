drop table if exists pet, person;

create table person(id serial primary key, name varchar(50) unique, password varchar(50));
create table pet(id serial primary key, name varchar(50), species varchar(50), food varchar(50), owner_id integer references person);

insert into person values (default, 'shelter', 'password');
insert into person values (default, 'shaggy', 'password');

insert into pet values (default, 'fluffy', 'cat', 'cat food', 1);
insert into pet values (default, 'inky', 'cat', 'cat food', 1);
insert into pet values (default, 'rufus', 'dog', 'dog food', 1);
insert into pet values(default, 'scooby', 'dog', 'scooby snacks', 2);


-- create a function that takes in a person_id and returns the number of pets they've adopted:
create or replace function get_num_pets(person_id integer)
returns integer -- specify return type
language plpgsql -- specify procedural, postgresql
as 
$$
begin 
	-- body of the function, returning the number of pets that correspond to the person_id:
	return (select count(*) from pet where owner_id = person_id);
end
$$;

-- call the function:
select id, name, get_num_pets(id) from person;



drop procedure adopt;
-- Stored Procedure - perform some actions, like adopting a pet:
create or replace procedure adopt(new_owner_id integer, pet_id integer)
language plpgsql 
as $$
declare -- in this block, we can define our variables
	p_current_owner_id integer;
begin 
	-- first, we want to find the pet's owner and store it in the variable we created:
	-- the WHERE condition finds the correct pet
	-- on the SELECT side, we're taking the owner_id and storing "into" the p_current_owner_id 
	select owner_id into p_current_owner_id from pet where id = pet_id;

	-- now that we have the current owner id, we can check if the pet is already adopted:
	if p_current_owner_id = 1 then -- if the pet is stil at the shelter, we adopt, otherwise 
		update pet set owner_id = new_owner_id where id = pet_id;
	end if;
end;
$$;

-- call the procedure (Shaggy adopting Rufus):
call adopt(2, 3);

select * from pet;

select id, name, get_num_pets(id) from person;




