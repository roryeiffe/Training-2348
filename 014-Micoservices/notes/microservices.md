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