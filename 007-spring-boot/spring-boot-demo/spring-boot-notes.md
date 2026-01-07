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