## Spring Boot
- Used to rapidly create applications
- Convention over Configuration
  - Spring Boot will make a lot of assumptions about the project
    - For example, if we have a Spring Web dependency, web server is configured for us
    - If we have Spring Data, we just have to set up repositories (data layer)
      - and the object-relational mapping is handled for us
  - With all these conventions, we do still have the ability to change them
  - But, starting with assumptions will make creating the applications quicker/easier

### Autoconfiguration
- The process by which Spring Boot automatically configures aspects
  - of the project based on dependencies
- For this to work, we need an annotation (@EnableAutoConfiguration)
  - Shortcut Annotation (@SpringBootApplication) that includes various annotations
    - implicitly (including @EnableAutoConfiguration)
    - Also includes @Configuration
      - Treats the class as a source of Bean definitions
    - And @ComponentScan
      - Will automatically scan the packages for beans
        - Looks for @Component annotation (this annotation is placed over classes that should be treated as beans)

### Spring Initializer
- Website online, where we can specify meta-data of our project (name, version, dependencies)
  - Will automatically generate a zip file that includes all of the starter/boiler plate code
    - pom.xml
    - packages
    - App.java with proper annotations
    - AutoConfiguration, when applicable (Spring Web, Spring Data)
- start.spring.io
- Specifying meta-data
  - Maven
  - Group Name
  - Java 17
  - Dependencies
    - Lombok
    - Spring Web
    - Spring Data
    - Postgresql Driver
    - H2 - a way to test database operations without having to set up a database
      - In memory
      - Easier to setup
### Stereotypes
- @Component - if we place this over a class, that class will be treated as a bean, and can be managed by spring
- Stereotypes are annotations that include the basic functionality of @Component but also provide information on the class:
  - @Repository - tells Spring that a bean should be created based on the repository and tells us that the class is a repository
  - @Service - same thing but used for Service classes
  - @Controller - used to mark controllers
- We could use @Component for all of these, but it's best to be specific and use the correct stereotype

### Spring Boot Devtools
- It is a dependency that once you place in pom.xml, makes the Spring Boot application restart whenever we make changes to the source code
- In IntelliJ -> File -> Settings -> Compiler
  - Make sure "Build Project Automatically" is checked


## Spring Boot Project

### Spring Data
- When setting up our entities, we can use annotations (not spring-specific, but related to the Java persistence API) to map classes to tables and fields to columns
- entity - placed over a class, maps that class to a table (can specify name of table)
- column - placed over a field, maps field to a column in the table (can specify name, constraints)
- Id - placed over a field, indicates that this field is the primary key of the table
- GeneratedValue - lets us configure the auto-generation of values for this column (like serial type)

#### Repositories
- For each entity we have, we will usually create a Repository for the entity
- Interface, so we only have to define the method signatures
- Repository interfaces that we make will extend from JpaRepository which includes (either in the interface itself or interfaces that it extends from) a lot of standard data-related methods (Create, Read, Update, Delete)

#### Derived Queries
- In our repositories, we can add method declarations that perform actions based on their name
- ex: findByName(String name) -> will find all records whose name field matches the parameter
- [Reference for more types of Derived Queries](https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html)

#### Custom Queries
- We can write queries in native SQL language
- Especially useful for complex queries that might not be fulfilled by the derived queries
- We just place @Query over the method declaration in the Repository interface


### Spring web

#### ResponseEntity
- The ResponseEntity class can be used to "wrap" around the entity that we're sending back
  - Allows us to specify the status code (200 for success, 400s for client-side error, 500s for server-side error)
- It is best practice to return responseEntity objects as opposed to the entity itself


### Lombok Fix
- In order for Lombok to work, Annotation Processing needs to be enabled
  - In IntelliJ, go to File -> Settings
  - On the sidebar, find Build, Execution, Deployment -> Compiler -> Annotation Processors
  - Ensure the "Enable annotation processing" box is checked at the top

### H2 Database
- In-memory database
  - Easier to set up, we just include the dependency and Spring Boot configures the H2 database for us
  - We lose the "permanent" aspect of databases so h2 databases should be used for testing and development
- We can also configure certain properties of the h2 database in the application.properties file