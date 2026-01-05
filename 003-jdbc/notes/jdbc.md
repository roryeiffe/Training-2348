## JDBC - Java Database Connectivity
- In our Java app, we have the logic for our back-end
- JDBC allows the Java application to interact with the database
- In order to use JDBC, we need to install some external dependencies
  - The easiest is way to do this is with Maven

## Design Pattern
- A set of rules/guidelines we can follow when designing an application or a specific part of an application
- In general, design patterns help us with organization, efficiency (storage or time), readability

### DAO Design Pattern
- Data Access Object
- An interface/class whose responsibility is to interact with the database
- CRUD - Create, Read, Update, Delete
- Typically have one DAO for each entity

### Service Layer
- As we know the data/DAO layer interacts directly with the database
- We also want to make a command line interface so that we can type in the console in our Java app and have those commands be sent to the database
  - We could, in theory, just have the command line layer directly call the DAO layer
  - It is best practice to include a service layer that sits between the data layer and the commandline (or controller) layer
  - Service classes are typically "boring", standard
    - But, in certain cases, we can and should include logic that is directly related to the project itself

### Singleton Design Pattern
- We only need/have a single instance of the class, rather than multiple instances
- For example, our DAO objects won't really care about state, so we only need one instance of this in our whole project
- We also need to set up a connection to our database and because the connection is the same across the entire project, we can also employ the Singleton Design Pattern

### Factory Design Pattern
- Set up a class whose responsibility is to create/produce something 
- We can set up a connection factory that produces a connection to the database (Singleton, so reuses the same connection)
- Can also set up a factory for the DAOs

## Hiding Credentials
- Right-click "main" 
  - new -> directory -> resources
- Inside the resources folder, create DbConfig.properties



## Packages
- entities - will store the classes that represent the objects that our project is dealing with (Pet, Person)
- data - this layer will handle database interactions, should have one DAO for each entity
- services - this layer will act as the intermediate layer between commandline and data, includes business logic
- commandline - setting up scanners and interactive menus to parse the user's choice and then take the appropriate action
- exceptions - store custom exceptions

## SQL Injection
- If we use String Concatenation to create our SQL queries (ex: String sql = "SELECT * FROM pet WHERE id = " + id + ";";)
  - Then, SQL Injection can occur where the user includes some harmful line of code in the input which then makes it's way into the string that is being sent to the database
- To get around this, we can use PreparedStatements which let us directly inject the fields into the statement
- IF we have dynamic values that go in the SQL statement, we use PreparedStatement. Otherwise, we can use a Statement

## ResultSet
- Whenever we get a returned value from the database, we use a ResultSet
- Acts like a pointer, initially pointing to an empty space
- We can use resultSet.next() to increment to the next space