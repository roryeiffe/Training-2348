## Hibernate and JPA
### JPA - Java Persistence API
- Specification, not implementation
- Used to examine, control, and persist data between Java objects and relational databases
- Supports object-relational-mapping with annotations
- Allows for switching between different ORM implementations
### Hibernate 
- Hibernate is an implementation of JPA that provides ORM capabilities
  - Implements JPA specifications
  - Map Java classes to SQL tables
  - Caching options for performance optimization
  - Includes its own HQL (Hibernate Query Language) for querying
- Some Advantages over JDBC
  - Automatic connection between objects and tables
  - Can connect with any type of database (Oracle, MySQL)
    - To change this, we can edit the Dialect in the configuration file
  - Abstraction - a lot of common tasks are abstracted away so we don't need to worry about the implementation: (connecting to database, querying, inserting data, transactions)

## Object-Relational Mapping
- Automatically converting data between relational databases and object-oriented languages like Java
- Addresses the following differences between relational databases and OOP
  - Granularity - difference in the number of mapped classes and number of tables in the database
  - Inheritance - Inheritance is supported in Object-Oriented languages but not in a database
  - Identity - SQL tables have primary keys which are used to identify objects. In Java, identity is determined by equality (2 objects are identical if they are equal according to .equals())
  - Association - In Java, we saw that classes/objects have dependencies on each other. In the database, these relationships are represented by foreign key relationships
- Object-Relational Mappers
  - Map objects to tables
  - Abstract away the details of SQL queries
  - Scalable, good for large projects
  - Caching
- Hibernate is the specific ORM that we will be learning

## hibernate.cfg.xml
- Contains information about the project including database connection credentials, dialect
  - Also, can configure the ability to log the implicit SQL commands that Hibernate is running
  - Can also configure how the tables are created/updated at start-up
- hibernate-configuration is the root tag
  - session-factory and contain database information
- This is the kind of information we would see in application.properties in Spring Boot
  - That is because Hibernate is being used implicitly when we set up a Spring Boot project with Spring data
```xml
<property name="hbm2ddl.auto">update</property>
<property name="dialect">org.hibernate.dialect.MySQL8Dialect</property>  
<property name="connection.url">jdbc:mysql://localhost/TUTORIALSPOINT</property>  
<property name="connection.username">root</property>  
<property name="connection.password">guest123</property>  
<property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property> 
```
- Properties
  - Connection Credentials
    - hibernate.connection.url
    - hibernate.connection.username
    - hibernate.connection.password
    - hibernate.connection.driver_class - specifying the driver class, related to the dialect
  - hibernate.dialect - which dialect we're working with (postgresql or mysql, etc.)
  - show_sql - log the SQL commands that are being sent to the database
  - hbm2ddl.auto - configure how the DDL commands are run when the SessionFactory object is created
    - create - create new tables based off Java entities, will drop and create if table exists already
    - update - update existing tables
    - validate - validate tables against provided objects and if validation fails, app won't work/start
    - create-drop - will drop all tables and recreate them based on Java classes (all data is lost so not good for production)
    
  - SessionFactory object - represents an instance of hibernate
### Clarification on Create vs Create-Drop
- create: The schema is dropped and recreated every time the application starts. The data persists in the database until the next application restart, at which point it is lost.
- create-drop: The schema is dropped and recreated on application startup, but is also dropped again when the SessionFactory (or EntityManagerFactory) is explicitly closed (which typically happens when the application stops). 

## Annotations
- @Entity - mark a class to be mapped to a table
- @Table - specify table detials
- @Id - mark field as primary key
- @GeneratedValue - indicates that the database should generate the value for this field
  - strategy argument to specify exactly how this is done
- @Column - specify column details (column name, length, unique, nullable)

## Interfaces
- Configuration - represents a configuration/properties file. Only created once
```java
Configuration config = new Configuration();
config.configure().addAnnotatedClass(Employee.class);
```
- Session Factory - one SessionFactory per database. Allows sessions to be created. 
```java
StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
```
- Session - used to connect to the database
  - lightweight - instantiate every time we need to interact with the database
```java
Session session = sessionFactory.openSession();
```
- Transaction - represents a unit of work in the database
```java
Transaction tx = session.beginTransaction();
//set of operation performed on DB, CRUD
tx.commit();
```
- Query - used to retrieve data from the database and create objects
```java
Query query=session.createQuery();
```

### Native Queries
- Hibernate does offer its own HQL language but we can also write native SQL queries 
  - Letting us write PostgreSQL-like commands
- session.createNativeQuery(String query, class clazz)
  - Assuming we have set up a string with the SQL query, pass that in
  - Can specify which query to run and the class to be returned
- Stack Overflow on SQL Injection: https://stackoverflow.com/questions/31314209/prevent-sql-injection-with-hibernate 

### Object States
- Are the Java objects connected/in sync to the database? 
- Transient - an object is created but not yet associated with a Hibernate session
  - Doesn't represent a row in the database
- Persistent - an object that is associated with a session
  - Represents a row in the database
  - Hibernate will detect changes and synchronize that with the database
  - We can make a transient object persistent by invoking save(), persist(), saveOrUpdate()
- Detached
  - When the persistent object's session closes, the object will be in the detached state
  - Changes to the object will no longer affect the database
  - If this object gets re-attached a session, it will be persistent



### Hibernate Demo
- Start by creating a Maven project with the Maven Archetype Quickstart archetype
- DBraver opened up with a new database created
  - create database name;
  - Connect to it

## HQL
- Hibernate Query Language
- Object-oriented query language
- Query against objects instead of tables/columns
- Advantages
  - Database independent - we can abstract the logic away from the specific dialect
  - Supports OOP concepts abstraction, inheritance
- To use HQL, we invoke session.createQuery(String hql, Class clazz)
  - Similar format to createNativeQuery