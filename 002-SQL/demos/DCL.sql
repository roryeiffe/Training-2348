-- create a new user
--drop user intern;
--create user intern with password 'intern123';

-- remove delete permissions from postgres user 
revoke delete on financial_information from intern;

-- we want the intern to be able to read data, but not edit it:
grant select on financial_information to intern;

drop table if exists financial_information ;
create table if not exists financial_information(id serial primary key, amount integer, password varchar(50));
insert into financial_information values (default, 10000, 'secret password');

select * from financial_information ;

delete from financial_information ;

select * from financial_information;