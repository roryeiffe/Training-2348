drop table if exists person;

-- create a table
create table person (id serial primary key, person_name varchar(50), occupation varchar(50), salary integer);

insert into person values (default, 'rory', 'astronaut', 500);
insert into person values (default, 'harry', 'wizard', 200);
insert into person values (default, 'ron', 'wizard', 100);
insert into person values (default, 'luke', 'jedi', 0);
insert into person values (default, 'gandalf', 'wizard', 1000);
insert into person values (default, 'shrek', 'vigilante', 300);
insert into person values (default, 'harry', 'musician', 2000);
insert into person values (default, 'anna', 'musician', 2000);
insert into person values (default, 'mike', 'musician', 2000);
insert into person values (default, 'ben', 'musician', 2000);
insert into person values (default, 'dan', 'musician', 2000);
insert into person values (default, 'han', 'musician', 2000);
insert into person values (default, 'gandalf', 'wizard', 1000);
insert into person values (default, 'gandalf', 'wizard', 1000);
insert into person values (default, 'gandalf', 'wizard', 1000);

-- select all rows, all columns:
select * from person;


-- specify indidual columns:
select person_name, occupation from person;

-- specify rows using WHERE
select * from person where salary > 300;

-- select by id:
select * from person where id = 3;

-- like keyword, can do some pattern matching
select * from person where person_name like '%a%';
select * from person where person_name like '%y';

-- dates:
alter table person add column bday date;

-- fill in bday values:
update person set bday = '1970-01-01';
update person set bday = '1980-07-31' where person_name = 'harry';
update person set bday = '1980-04-01' where person_name = 'ron';
update person set bday = '02-09-2010' where person_name = 'shrek';

select * from person where bday > '1970-01-01';
select * from person where bday < '1980-04-01';

-- order by
select * from person order by salary asc, person_name desc;
-- limit (top 5 largest salaries)
select * from person order by salary desc limit 8;

-- scalar functions:
select upper(person_name), length(person_name) from person;

-- aggregate functions:

-- Group By, group results by a specific column (in this case, grouping by occupation which 
-- will allow us to examine differnt things like salary in terms of the group)
-- for all fields that you select, need to make sure they appear in GROUP BY
select occupation, avg(salary) income, sum(salary) total, max(salary) highest, count(salary) num_workers from person group by occupation;

-- Set Operations - act on 2 different query results:
(select * from person where occupation = 'wizard')
union -- should include all results from both queries:
(select * from person where salary > 500)
-- how could we achieve the same thing without set operations?

(select * from person where occupation = 'wizard')
union all -- should include all results from both queries (including duplicates)
(select * from person where salary > 500)

(select * from person where occupation = 'wizard')
except -- should include all wizards except those that have a salary > 500
(select * from person where salary > 500)

(select * from person where occupation = 'wizard')
intersect -- should include all wizards that have a salary > 500
(select * from person where salary > 500)


-- sub-queries - using the results of one query within our outer query:
-- using the results of an inner query that calculates the average salary in the WHERE condition
-- of the "main" query:
select * from person where salary >
(select avg(salary) total_average from person);

-- set up a view to store rich wizards 
create view rich_wizards as
select * from person where occupation = 'wizard' and salary >= 1000;

select * from rich_wizards limit 2;
















