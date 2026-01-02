drop table if exists bank_account;
create table bank_account (id serial primary key, amount integer check(amount >= 0));

insert into bank_account values (default, 1000);
insert into bank_account values (default, 2000);

select * from bank_account ;

-- Transactions, transferring money between from account 2 to account 1
begin; -- begin the transaction
update bank_account set amount = amount + 100 where id = 1;
update bank_account set amount = amount - 100 where id = 2;
commit; -- persist these changes to the database

select * from bank_account ;

-- Transactions, transferring 2000 dollars from account 1 to account 2
begin; -- begin the transaction
update bank_account set amount = amount + 2000 where id = 2;
update bank_account set amount = amount - 2000 where id = 1;
commit; -- persist these changes to the database

select * from bank_account ;


-- Transactions, transferring 2000 dollars from account 1 to account 2
begin; -- begin the transaction
update bank_account set amount = amount + 200 where id = 2;
update bank_account set amount = amount + 200 where id = 1;
rollback;
commit; -- persist these changes to the database

select * from bank_account ;


-- savepoint:


select * from bank_account;

begin; -- begin transaction
insert into bank_account values (default, 3000); -- this will not be undone if we rollback to the first savepoint
savepoint first_save; -- set up savepoint
insert into bank_account values (default, 4000); -- this will be undone if we rollback to the first save point
rollback to savepoint first_save;
commit;
select * from bank_account ;







