## The Workshop Application
- Workshop Application
  - Workshops can be given to teach certain skills/information
  - People can register for workshops
  - Workshops have limited capacity, so will need compensating actions to prevent going over capacity
- Services
  - Workshop Service - Create/Read workshops
  - Registration Service - Handles Registration logic
    - Users can register for a certain workshop or they can leave
    - We can imagine, we will need some information from the Workshop service like capacity, workshop id
    - Good example of Feign communication

## The Workshop Service
- We need to create a Spring Boot app (start.spring.io) with the following dependencies:
  - Spring Web
  - Spring Data JPA
  - H2
  - PostgreSQL
  - Spring Boot Actuator
  - Lombok 
  - Spring Cloud Consul Discovery
    - Consul is a service that lets other services find each other
  - Spring Cloud Config Client
    - A way to centralize configuration for the application
- Download the zip file, extract it, and open in IntelliJ

### Order of Classes/Packages
- Configuring properties in the application.yml
- Create Model classes
- Create DTOs (can use records for immutable DTOs)
- Repository Layer - works like we've seen them before
- Service
- Controller
  - Workshop Controller - standard controller
  - Internal Workshop Controller
    - Configuring endpoints that we want the other microservice to access
  - Global Exception Handler

### @Version Annotation
- We can annotate a version field (must be a whole number like int, Long, etc.) with Version annotation
- Under the hood, JPA
  - Read the entity + version
  - Allows changes
  - When we try to update, check the version
  - Fails if we see that another transaction tried to modify it
- https://stackoverflow.com/questions/2572566/java-jpa-version-annotation

## Registration Service
- Will provide the functionality to register for a workshop or un-enroll from a workshop
- Can also view recent registrations
- Will need to specify compensating actions if we try to register and it fails
- Will also implement CQRS, have different models for read and writing registrations
### Dependencies
- Go to start.spring.io and include the following dependencies:
  - Spring Web
  - Spring Data JPA
  - PostgreSQL
  - H2
  - Spring Boot Actuator
  - OpenFeign
  - Spring Cloud Consul Discovery
  - Spring Cloud Config Client
  - Lombok