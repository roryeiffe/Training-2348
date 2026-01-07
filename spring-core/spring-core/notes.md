## Spring

- Family of frameworks that are used to create Java applications
  - Loose Coupling - if the components in an application are loosely coupled, changing one
    - component shouldn't require a lot of refactoring in order for it to still work with the rest
  - Quicker than regular Java
    - Particularly Spring Boot is a way to create enterprise applications quickly

### Dependency Injection
- The process of injecting dependencies where they are needed
  - Dependencies, in this context, referring to other objects/classes
    - Not to be confused with Maven dependencies which are external libraries
- Inversion of Control
  - Normally, without spring, we are responsible for managing/instantiating objects
  - With spring, that control is taken care of the framework itself
  - We just have to configure the types of objects that we want to have created (including class, values, dependencies on other objects)
  

### Bean
- Beans are objects that are managed by Spring

#### Configuring Beans
- There a few different ways to configure beans
- XML-based Configuration - 
  - We define a file (ex: beans.xml) in which we use markup language to define beans (class, values, name)
  - From our code, we can utilize the information in the beans.xml to create objects
  - Benefit - all of the bean definitions are in one place (so easy to go back and manage all of them)
  - Drawback - Not as intuitive, might have to go back and forth between xml and Java code to understand what's happening
  - Property-Based Injection - we need a no-args constructor and setters defined
    - We define the property values and Spring leverages the methods to create the object
  - Constructor-Based Injection - we need a constructor that has all fields defined
    - Index-based in the xml
- Annotation-based Configuration
  - Use annotations in our Java code to define our beans
  - @Autowired - used to automatically inject a vale into a given field
  - Benefits - the Spring configurations are directly in our Java code so it could be slightly easier to understand
- Java-based configuration
  - This method also uses annotations but they are different from those used in annotation-based configuration
  - Specifically this method is about creating Java classes that manage and produce beans
  - Benefits - annotation-based, so it is apparent in the code
    - Also because we are using Java, we can set up custom methods to help manage our beans
  - Drawbacks - It is a little more work to create the classes

#### Bean Scopes

#### Bean Lifecycle

### Lombok
- Lombok is a library that lets us use annotations to specify which of the "standard" methods
  - we have for our entity classes
    - constructors
    - getters/setters
    - toString
- Lombok is NOT inherently tied to Spring
  - We can make a Spring application without Lombok
  - And we can use Lombok in a non-spring application