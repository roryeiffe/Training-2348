## The  Workshop Application
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