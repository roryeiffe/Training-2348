## Databases, SQL
- If Java is our language with which we write logic and back-end code, SQL is pertaining to the storage of the data
  - Data is permanently stored as opposed to just existing in memory in a Java program
- SQL - Structured Query Language
  - Structured - organized data, tables, schemas that define structure of data
  - Query - commands we send to the db to retrieve data, also have commands to insert/update data in structured ways
  - Language - human-like syntax for interacting with databases

### Dialects
- Different dialects in SQL have slightly different syntax/commands but they also have a lot of the core commands/syntax in common
  - For example, going from MySQL to PostgreSQL and vice versa is relatively straightforward 
- Do NOT get this confused with sub-languages
  - SQL sub-languages refer to groupings of SQL commands based on functionality
  - DDL, DML, DQL, TCL, DCL
  - No matter which Dialect we choose, we would still be working with the different sub-languages

## Relational Databases
- Database - collection of data, we will be working with a single database for our project
  - A database can have many tables
- Tables - Relations - represent a specific entity, object that we want to store
  - ex: Pet, Owner, Book, Account 
  - Organized 
    - Columns - fields (name, id, email)
    - Rows - Records
      - the actual entries in our table
      - ex: 'joe', 10, 'j@gmail.com'
      - In Java, like instance
- Relational - relate 2 tables together
  - We relate tables using primary keys and foreign keys
  - ex: a person can adopt many pets
  - ex: a class has multiple students

### Multiplicity Relationships
1. One-to-One
  - One entity is related to exactly one entity
  - ex: Person Table and Social Security Table
    - One person should only have one social security card
    - One Social Security Card should only be mapped to one person
2. One-to-Many
  - One entity has 0 or more relations to another entity, that other entity is only mapped to the initial entity
  - ex: Social Media - one post can have many(0 or more) comments but each comment only belongs to one post
3. Many-to-Many
  - one entity connects to 0-many other entities each of which can also connect to 0-many others
    - student to class - one class can have many students and each student can be enrolled in multiple classes
    - employee to departments - 1 department can have multiple employees, employees can be in different departments


### Data Types
- integer - stores whole numbers
- serial - like an integer, but lets us use the default keyword when inserting values to automatically choose the next value (incrementing by 1)
  - useful for ids where we need a unique id for each record
- varchar - like a String, stores a sequence of characters
  - When we declare a column that has the varchar type, we include a max number of characters (can vary depending on the column)
- char - similar to char but if the entire space is not used (ex: allocated 50 but the text was only 10 characters long) extra slots will be padded with spaces
- date - store a date (year, month, day)
  ```sql
  update person set bday = '1970-01-01';
  ```
- timestamp - store date+time
```sql
insert into work_times values ('2016-06-22 19:10:25-07');
```

## Sequences
- When we use the serial keyword in PSQL, a sequence table is created
- Table starts at 1 and increments every time we use the "default" keyword to insert into the column that was defined as "serial"



## Constraints
- Restrictions that we place on our columns to ensure our table/data acting the way want it to

### Keys

#### Primary Keys
- Uniquely identify a record in a table
- Under the hoods, PRIMARY KEY constraint ensures that the values are not-null and unique
  - Ids need to be different from each other
  - Ids should not be null

##### Primary Keys vs Serial
- Most of the time, we will see serial and primary key together
- While related, they don't do the exact same thing
  - Serial is a data type that allows the values to be automatically incremented when we insert
  - PRIMARY KEY is a constraint on a column that guarantees each value is unique and not null

#### Foreign Keys
- Used to connect 2 different tables
- Set up multiplicity relationships
- A foreign key in one table will reference primary key in a different table
- We use the "references" keyword to set up a foreign key relationship
  - ex: pet table
    - setting up a field that connects pet to person: ```owner_id references person```
      - By default, this would reference the primary key in the person table
    - ```owner_id references person (person_id)``` - references the "person_id" column specifically

### Non-Key Constraints
- UNIQUE - forcing values in that column to be unique (implicitly applied when we use the PRIMARY KEY constraints)
  - CREATE TABLE pet (id INTEGER UNIQUE);
- NOT NULL - forcing values to not be null (implicitly applied when we use the PRIMARY KEY constraints)
- CHECK - we can apply a custom condition to a table (require age > 18)
- DEFAULT - can set up a default value if none is given

## Referential Integrity
- When we are editing or inserting to a table that has some sort of relationship with another table, we want to make sure that the references are maintained and are valid
  - ex: If we have a pet (man) to owner (one) relationship, we don't want to have a pet with no valid owner
- Foreign Keys are the solution to this
  - Set up a foreign key in the pet table that references the person table. If we try to insert a pet with an invalid person id, we will get an error
  - For many-to-many relationships, we would need to make sure that the values we put in the lookup table are also valid
- Cascade - When we delete/update rows/records that have dependencies, we can configure the cascade behavior to eliminate the dependent records/tables/views so we still adhere to referential integrity


## Sub-Languages
- Data Definition Language (DDL) - creating tables, setting up structure, modify tables/columns
  - create - create tables (or other entities, ex: views)
    - Can only create a particular table once before you get an error about "Relation already exists"
    - can check if a table exists before creating it
      ```create table if not exists ...```
  - alter - alter a pre-existing table in SQL
    - change up the columns, constraints, structure, not changing the table data itself
    - imagine we accidentally named the column foood, we can rename it:
    ```sql
    alter table pet rename column foood to food;
    ```
    - drop - get rid of a table completely
      - we can also check if a table exists before trying to drop it:
        - ```SQL
           drop table if exists pet
           ```
    - truncate - completely wipe a table of its data but the table will still exist
- Data Manipulation Language (DML) - modifying/inserting/deleting data that's in the table
  - INSERT - add new data to the table
    - we can specify the fields so we can explicitly assign values to each field:
      - ```insert into pets (id, name, species, food) values (1, 'gollum', 'cat', 'chicken');```
    - If we don't specify the fields, we just need to make sure that they match the order in which they were defined:
    - ```insert into pets values (1, 'smeagol', 'cat', 'chicken');```
  - UPDATE - update existing data
    - ```update pets set name = 'garfield' where id = 1;```
  - DELETE - removing 1 or more records from the table
    - ```delete form pets where id = 1;```
  - WARNING: any update/delete commands without a "WHERE" clause are dangerous because then it would update/delete EVERY record in the table
- Data Query Language (DQL) - reading data from our tables
  - SELECT - selecting data from the table
    - General Format: ```select <columns> from <table> where <condition>```
      - If we want all columns, can use the * symbol
    - Clauses:
      - LIKE clause is used to compare string
        - ex: all names that end in y: ```select * from person where person_name like '%y';```
          - use the % sign as a catch-all delimiter
      - ORDER BY - order the results of the query in numerical/alphabetical/chronological order, depending on the data type
        - we can specify multiple columns which case the latter columns will be used as tie-breakers
        - we can also specify the order using asc or desc (default will be ascending order)
      - LIMIT - limit the number of rows that we retrieve from the column (will go towards the end of the query)
        - ex: LIMIT 5
      - GROUP BY - group the results by a certain column
      - HAVING - like WHERE but acts on a group of records rather than an individual record
  - Set Operations - act on the results of 2 queries
    - union - takes all results from either query
    - intersect - takes records that exist in both queries
    - union all - takes all results (including duplicates)
    - except - takes everything from the first query results except those that are also found in the results of the second query
  - sub-query - using a query within another query
    - ex: selecting every record from the person table that has a salary that is higher than the average salary from the table
    ```sql
      select * from person where salary >
      (select avg(salary) from person); -- sub-query because it exists within the outer query
    ```
  - Views - temporarily store the results of one query
    - We can also examine views within the DBeaver interface
    - NOT creating a new table but we can select from views:
- Transaction Control Language
  - Transaction - series of commands (usually DML) that we execute in SQL
    - 1 or more commands that are executed together and related
  - ACID Acronym helps us remember what transactions should follow
    - Atomicity - transactions should be all-or-nothing. Either all commands should go through or none
      - Ex: transferring money from one account to another 
        - Donor loses money
        - Recipient gains money
        - We wouldn't only 1 of those operations to happen
    - Consistency - maintaining the integrity of the database before and after the transaction
      - Transaction shouldn't break any rules set up for the database
    - Isolation - What happens in one transaction doesn't affect another one
      - For example, don't want one transaction to read uncommitted data from another in-progress transaction
    - Durability - in cases of faults/disasters/shutdowns, want to make sure the database is able to recover
  - TCL Commands - 
    - Begin - begin/start a transaction
    - Commit - at the end of the transaction, we commit (persist) our changes to the database.
    - Rollback - return to the state of the db before the transaction started
    - Save Point - set custom save points to rollback to
- Data Control Language (DCL)
  - Controlling who can do what in our database
  - Especially useful for databases with multiple users
    - Will need to create users for demo purposes
  - Required to set up for enterprise databases/applications
  - The default user that we create is probably "postgres", with whatever password you choose
  - DCL Commands
    - grant - give permission to a user for certain operations on a particular table
    - revoke - remove permissions from a user for certain operations on a particular table

C - Create - insert, create
R - Read - select
U - Update - update
D - Delete - delete, drop

## Functions in SQL:

### Aggregate Functions
- Acting on a group of records (useful in queries that utilize GROUP BY)
- Examples:
  - Min - take the lowest value
  - Max - highest
  - Avg - average of all values
  - Sum - sum of all values
  - Count - number of values
  - First - the first value
  - Last - the last value


### Scalar Functions
- Acts on a single record:
  - Examples
    - lower - take a single varchar/char and make it lowercase
    - upper - make it uppercase
    - length - return the length of the varchar/char