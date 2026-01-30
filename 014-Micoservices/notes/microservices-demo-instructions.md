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

## Consul
- Install Consul service https://developer.hashicorp.com/consul/install 
- Download + unzip the folder
  - Navigate to it
  - Run ./consule.exe agent -dev
    - Default port is 8500
    - Once up and running, we should be able to go to localhost:8500 and see the different services
- Sometimes, 8500 might be being used
  - We can add a flag -http-port=8501
  - Or we can locate the process that's running on 8500
    - netstat -ano | findstr :8500
  - Run command to end process using the process id (last column from the previous command)
    - taskkill /F /PID 12345
      - Replace 12345 is the real PID
      - Might need to be in admin mode

## Load Balancing
- Now that services are being discovered by name, we can run multiple instances of Workshop service
- So, whenever we make a request to Workshop from Registration service via Feign client, it will search by name (Consul) and be distributed over the different instances of the service
- Navigate to the directory containing the service/project
  - mvn spring-boot:run -D spring-boot.run.arguments="--server.port=8084"
- Now that we have multiple instances of a service running, we will want to connect to a real, non-H2 database so that data source remains consistent across the instances
  - Make sure to set up the connection to a postgres db for those services that have multiple instances

## Circuit Breaker
- Make sure we have the Resilience dependency in Registration service pom.xml
- Update application.yml on the Registration service and configure behavior for the circuit breaker, timeout, retries
- Create DownstreamUnavailableException
- Create WorkshopGateway
- In Saga service, replaced calls to WorkshopClient with WorkshopGateway (and invoked the .join() because CompletableFuture)
- Configured our Global Exception Handler to handle downstream exceptions
### To test things out
- Start up Consul, Workshop Service, Registration
- Run a few calls from registration service that interact with Workshop Service (reserve, release)
- Shut down workshop instance
- Try the calls again and verify that the proper status code/message are being returned

## Spring Cloud Gateway
- Create a new Spring Boot project
  - Consul Discovery
  - Actuator
  - Spring Cloud Gateway Reactive
- Configure the routing behavior
  - application.yml
  - Set up a bean that lets us specify the logic explicitly

## Spring Cloud Config Server
- Create a new Spring Boot project with:
  - spring-cloud-config-server
  - spring web
- Create a Github repo containing the yml files for each service (example: workshop-service.yml, registration-service.yml)
  - In each file, we will include the yml properties that we want to change without redeploying
    - server port
    - DB credentials
    - service URLs
    - Resilience 4J settings
  - Some properties will stay in the application.yml in the service
    - application name
    - specify where to retrieve the config information via the config server
- In the cloud server, we add the @EnableConfigServer annotation over our main class
  - Also, fill out the application.yml and specify where we're getting our config information (Git)
- In each service Workshop, Registration
  - Comment out the datasource configuration
  - Add 
```yml
spring:
  application:
    name: orders-service
  config:
    import: "optional:configserver:http://localhost:8888"
  cloud:
    config:
      enabled: true
```
- Sensitive data should not sit in the repos as plain-text
  - One solution is to use secrets
  - Environment variables can be defined locally and then utilized in the config files