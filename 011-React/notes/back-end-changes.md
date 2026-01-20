- Over the PetController and PersonController, we add the annotation: @CrossOrigin(origins = "*")
  - Will allow us to reach the back-end from our React app, otherwise, we will encounter a CORS error
- Updated Pet class to keep track of the owner
  - Pet now has a field Person owner (this is so we can have access to the owner when we retrieve the pets from the back-end, can use that to check if the pet is already adopted)
  - Each Person object has a list of pets, each pet has a person object, each of which has a list of pets
    - We've created an infinite loop of data, which will throw errors during the serialization process 
    - We can add annotations over these fields to specify whether or not they are included in the JSON that we are returning
    - @JsonBackReference - placed over the Person field in the Pet class, indicates that that field will not be serialized
    - @JsonManagedReference - placed over the pets field in the Person class, indicates that field will be serialized
  - Otherwise, will encounter this: ```Could not write JSON: Document nesting depth (501) exceeds the maximum allowed (500, from `StreamWriteConstraints.getMaxNestingDepth()`)```
- Include a file called 'data.sql' in our resources folder (this code should run when we start the Spring application)
```sql
insert into person (name, password) values('The Shelter', 'shelter');
insert into person (name, password) values('Shaggy', 'loveScoob');
insert into person (name, password) values('John', 'Garfield');

insert into pet (pet_name, food, species, person_fk) values ('Garfield', 'lasagna', 'cat', 3);
insert into pet (pet_name, food, species, person_fk) values ('Scooby Doo', 'Scooby Snax', 'dog', 2);
insert into pet (pet_name, food, species, person_fk) values ('Fluffy', 'tuna', 'cat', 1);
insert into pet (pet_name, food, species, person_fk) values ('Biscuit', 'kibble', 'dog', 1);
```
- Also want to update application.properties:
```
# ensure data.sql runs:
spring.sql.init.mode=always
# create tables first, before trying to run data.sql:
spring.jpa.defer-datasource-initialization=true
```
- Added a method to PetService that returns the owner of a pet given pet id
- Also added a corresponding PetController method that calls that service method