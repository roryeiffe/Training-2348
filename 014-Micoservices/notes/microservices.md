## Microservices
- Architecture defined by small independent services, each focused on a specific business capability ('users', 'auth', 'payments', 'orders')
- Each service
  - Own its own codebase
  - Communicates with other services over the network (ex: HTTP/REST)
  - Often owns its own data, separate database per service
  - In theory, could use different languages but we'll sticking to Spring Boot

## Monolith vs Microservices
- Monolith
  - Single application that lives in one codebase
  - Often uses one database
  - Can be broken up into layers/modules but still run together as one unit
- Microservices
  - Multiple services working independently
  - Each service can be scaled independently
  - Services can communicate over the network

## Advantages/Disadvantages of Microservices
- Advantages
  - Independent Deployments - Make changes to one service without the need to redeploy/rerun the entire app
  - Team Autonomy - teams can own and work on their own specific services to end-to-end
    - Would still to communicate with services that they need to interact with
    - Updating code separately, other teams might not have to wait
  - Targeted Scaling - Can scale up a specific microservice without having to scale up the rest of the app that might not need it
  - Fault Isolation - If designed really well, can sometimes be cases where a service going down doesn't make entire application go down
  - Technology Flexibility - Because the services communicate over the network, can potentially have different tech stacks for different services when needed
  - Domain Boundaries - separation of business capabilities across the different services
- Disadvantages
  - Distributed Systems Complexity - Network failures, timeouts, outages are things that we have to manage with MSA
  - Debugging - A user's action could go through many different services, so it is hard to trace where faults happen
    - Could pass transaction id or some sort of identifier to track the request
  - Operational Overhead - calling and coordinating with different services takes time to set up
  - More Moving Parts - managing dependencies, APIs are synced up, updating services, making them backwards compatible
  - Latency - communicating between services takes time

## When to use Microservices
- When to use Microservices
  - If we have large/complex domain that could benefit from being split up
  - Multiple teams need independent delivery
  - Advanced DevOps (monitoring, CI/CD pipelines)
  - If certain parts of the application would benefit from independent scaling
    - Example: search or payment features are probably going to receive a lot of requests so could be scaled up while leaving other services alone 
- When to use Monolith
  - Small teams or early stage in an application
  - If we need to develop the app quickly and simply
  - If the domain is small, not too complex


## Saga Pattern
- Used to manage data consistency across multiple services
- Instead of one big transaction
  - A sequence of transactions
  - Each transaction updates one service's database
  - Instead of a rollback when things go wrong, we can take compensating actions to undo previous steps
    - Example if a user enrolls in a class and then something goes wrong in a later transaction, the compensating action would be to remove that user from the class
- Saga Design Pattern is useful for Microservices
  - Each service owns its database so traditional transactions are not able to span across different services safely
  - Network failures could cause certain actions to fail
- Sagas
  - Break work into logical steps
  - Accept temporary inconsistencies
  - If something does go wrong, we have explicitly defined rollback logic, can take compensating actions to undo what was done

## CQRS - Command Query Responsibility Separation
- Design Pattern where 
  - Commands (writes) and Queries (reads) are handled separately
  - Write and read models are different
    - Could contain different fields
### Commands vs Queries
- Commands
  - Change state
  - Return minimal info (success/failure)
  - Ex: createWorkshop, createOrder, approveRequest
- Queries
  - Not changing state
  - Returns data, including all the fields that we need

### Reasoning behind using CQRS
- Reads and Writes have different requirements
- Reads often outnumber writes
- Writes have specific business roles, validation, etc.
- Helps to make querying faster

### Advantages/Disadvantages
- Advantages
  - Better scalability, we can scale the read/write models separately
  - Can help simplify write logic
  - Could improve the efficiency of reads, only retrieving information that we need
  - Separation of Concerns
- Disadvantages
  - Code is more complex
  - More infrastructure to sync the data
  - Might not be necessary for smaller systems


## Front Controller Pattern
- Not specific to Microservices
- In general, the Front Controller is a design pattern where we have some central controller that centralizes request handling
- In Spring MVC (monolith or microservices), the DispatcherServlet
  - Client sends an HTTP request
  - DispatcherServlet receives the request
  - Forwards to appropriate controller, based on the annotations/endpoints we specify
  - Handles response rendering
    - In default MVC, specify a view (some page, like HTML) to return 
    - With RESTful controllers, we return data (front-end is handled in React)
- This pattern applies to both Monolithic and Microservice applications
  - Same for Saga and CQRS

## Feign Client
- Helps with service-to-service communication
- Different services need to communicate with each other
- Imagine we have 2 Spring Boot Web applications (microservices)
  - Service 1: port 8081
  - Service 2: running on 8082
  - If Service # 2 needs to access some data Service #1, could use RestTemplate to make a request to localhost:8081/persons/whatever and consume the data
- Feign Client makes this process easier. Lets us define a Java interface that represents calls to another service
  - Instead of using RestTemplate, we define an interface that will be implemented for us at runtime
### Benefits
- Clean, readable calls to other services
- Integrates with
  - Service Discovery
  - Load Balancing
  - Circuit Breakers
- Reduce boilerplate HTTP code

## Consul
- Service Discovery Tool
- In the Microservice Architecture, we have many different services
  - Services can register themselves with Consul
  - This allows other services to discover them dynamically, by name, so if the address changes we can still find it

### Why this is Important
- Microservices
  - Can change what address/ports they're running on
  - Require the ability to scale up to meet demand 
    - If we hard-coded the address, the requests would go there no matter what
    - But if we search for the service by name, and we have scaled up a given service by running multiple instances, load balancing can take effect and distribute the requests across multiple instances

## Load Balancing
- Distributes incoming requests to multiple instances of a service
- Benefits
  - Improves Performance
    - One service won't get overloaded
  - Increases availability
- Integrates with
  - Feign Client
    - In our Feign client, we will specify the name of the service, load balancing will make it so we distribute requests across that service (assuming multiple instances are running)
  - Spring Cloud Gateway

## Circuit Breaker (Resilience 4j)
- A fault-tolerance mechanism that helps to prevent cascading failures in microservice architecture
### Example of the Problem
- Registration service calls Workshop service
- If Workshop service becomes slow or unavailable, then the Registration service wait and wait 
- System becomes slower as registration system waits
- Circuit Breaker will let us specify behavior for "waiting" on other services, wait time, fallback behavior, retry behavior

### Circuit Breaker Behavior
- Closed - requests will flow as normal
- Open - requests fall flat
- Half-Open - used to test if services have recovered

### Why it's Important
- System Stability 
- Prevents total outages
- Better feedback about system operations

### Downstream vs Upstream
- Downstream - a service that is being called (Workshop)
- Upstream - a service that calls another one (Registration)

## Cloud Gateway
- Spring Cloud Gateway is a lightweight, reactive API Gateway built on Spring WebFlux

- Sit at the edge of our system and acts a single entry point for client requests, routing them to the appropriate service
- Right now, we have multiple services, each running on different ports
  - Could be confusing for the client application, managing different address, ports, etc.
  - With Cloud Gateway, we will have one entrypoint to our back-end system and the requests will be forwarded to the proper service
  - Integrates with load balancing
    - Client sends request to Gateway
    - Gateway identifies which service to send it to
    - If we have multiple instances and we configure the Gateway properly, the request could be sent to any of those instances
- Without a Gateway
  - Client would have to know every service URL
  - Also would have to update client code whenever an individual service endpoint changes
- With a Gateway
  - Clients talk to one URL
  - Routing logic exists in one place
  - Lets us change up the back-end services more freely
  - We can configure rules to hide our internal controller
- React/Front-End
  - Will call the Cloud Gateway
    - Gateway will handle the forwarding
  - All we need to know from the front-end side is what address/port the Gateway is service is running on because that will be our entry point to the system
  - Other services are still running, where the requests are being forwarded to

## Cloud Config Server
- Centralized configuration for all of our services
- Configuration is stored in a centralized location (like Git)
- Allows for consistent configuration across services
- Easy to update configuration in one place
- If we need to change some of this info, we don't need to redeploy the app 