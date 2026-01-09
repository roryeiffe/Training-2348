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

#### Spring Boot Actuator
- Dependency that we can add to our project that provides us access to certain metrics about our project
- Once the dependency is added and the project is running, we can access those metrics by going to 
  - localhost:8081/actuator/metric
  - ex: localhost:8081/actuator/health - general health information 
  - /beans - shows the beans that are in use for the application
- Configure which endpoints are available in our application.properties
  - management.endpoints.web.exposure.include=beans,health
- We want to include the following dependency:
```
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

#### Spring Environments
- As we've seen, we can configure certain aspects of our environment using the application.properties file
  - server.port=8081
  - Configuring information about our h2 database, enabling console, setting the credentials
  - Specifying which endpoints are available for Spring Boot Actuator
- Some of these might change depending on the context (test, development, production)
- To set up different scenarios, we can set up multiple properties files and configure Spring Boot to a specific one
- These properties files should go in the resources folder
- We can utilize this for the next project in case different environment needs

#### RestTemplate
- Representational State Transfer
- RestTemplate allows us to consume external web services from within our Spring project
- Not super applicable right now and for project 1 because we don't have a need to access another webservice/API
- It will definitely come in handy when we reach Microservices where our services will need to interact with each other

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


### Handling Transactions in a Spring Boot Application
- Transactions let us group multiple SQL/database commands together so that if a failure occurs, the changes are rolled back
- ACID
- We will make use of @Transactional annotation which is placed over a method to ensure that those operations are executed within a transaction
  - Which class's methods are we going to annotating with @Transactional
    - DAO - DAO/repository methods typically include one operation
    - Service
      - the service layer is the layer that calls the Repository methods, meaning that multiple database operations could exist within a single service method
    - Controller
- Some of the properties we can define within a transactional annotation
  - readOnly - specifies that this transaction is only reading data as opposed to writing
  - isolation - specifies that the type of data that is allowed to be read (committed vs uncommitted)
    - Useful to specify so we aren't reading uncommitted data that could be rolled back
  - propagation - defines the behavior of whether or not we need a transaction, or to create a new one, or to use an existing one
    - If we have multiple methods that use transactions, we can configure them how we want


### Validation
- Spring provides us some annotations and utilities for validating data
- pom.xml dependency:
```
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
			<version>4.0.1</version>
		</dependency>
```
- Annotations
  - @NotEmpty - guaranteeing that the value is not empty
  - @Max()
  - @Min()
  - @Email - ensures a string fits the patterno of an email
  - Read more about them here: https://medium.com/@himani.prasad016/validations-in-spring-boot-e9948aa6286b 
- If the built-in annotations don't meet our validation requirements, we can create a validator with custom rules/logic