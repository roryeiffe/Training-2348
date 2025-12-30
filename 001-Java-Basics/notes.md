## Java
- Object Oriented - forming our code based on real life objects
  - many different classes
  - converting real life objects to code
  - Objects vs Classes
    - classes - blueprint
    - object - instance of class
    - can have multiple instances of the same class
- Machine Independent (Write Once, Run Anywhere)

## Compilation Process
- 2 step-execution
### Compilation
- .java file is passed through the compiler
  - look something like
    ``` 
    class Car {
        int wheels;
        String color;
    }
    ```
- Source code encoded into Bytecode (machine-independent)
- End result is a .class file
### Execution
- The main class file (starting point) is passed to the JVM
- Goes through three stages:
1. Class Loader - loads all classes that are used in the program
2. Bytecode Verifier - check that the bytecode doesn't contain any damaging instructions such as variables being used before being initialized
3. Just-In-Time Compiler - convert bytecode into machine code

![Diagram of Compilation](https://media.geeksforgeeks.org/wp-content/uploads/java.jpg)

Read More about the compilation process [here](https://www.geeksforgeeks.org/compilation-execution-java-program/)

## JVM, JRE, JDK
### JDK - Java Development Kit
- Provides everything you need to develop and run the Java program
- Includes development tools and JRE

### JRE - Java Runtime Environment
- Provides an environment to run (not develop) a Java program
- Used by end-users

### JVM - Java Virtual Machine
- Responsible for executing the Java program line by line
- Allows for WORA (Write Once Run Anywhere)

![JDK, JRE, JVM](https://media.geeksforgeeks.org/wp-content/uploads/20210218150010/JDK.png)

Read more about the JDK, JRE, and JVM [here](https://www.geeksforgeeks.org/differences-jdk-jre-jvm/)

Read more about Java [here](https://www.geeksforgeeks.org/java/)

## To Get Started
We'll need 2 things:
1. IDE (Interactive Development Environment)- IntelliJ, it will let us write code, run it, debug it
  - https://www.jetbrains.com/idea/download/#section=windows
  - https://www.jetbrains.com/idea/download/#section=mac

2. JDK - Java Development Kit which actually lets us compile and run the program
  - https://www.oracle.com/java/technologies/downloads/#jdk17-windows
  - https://www.oracle.com/java/technologies/downloads/#jdk17-mac

## IntelliJ
- File -> Settings
- File -> Project Structure
- Can check these out especially if running into errors that aren't being detected by red underline

## Java Packages
- Packages represent the "folders" and structure of our project
- Typically at the root level, we will have a package called "com.revature"
- In IntelliJ, right-click on the corresponding folder/package in which you want the package to reside
  - New -> Package
  - Give it a name with periods as separators

## Structure of Java classes
- Every file will have its own class (sometimes will have multiple helper classes but usually 1-to-1 relationship between classes and files)
- Declare class with "public class ClassName"
  - ClassName is capitalized
  - Objects will be lowercase
- Some classes have a main method which is the starting point for that class
  - Code written in the main method will execute
  - public static void main(String[] args)
    - public - accessible from different classes/packages
    - static - this method is scoped to the class rather than an object, meaning we don't have to instantiate the class to run that method
    - void - not returning any values from this method
    - main - the name of the method
    - String [] args - optional array of arguments (ex: DEBUG flag to indicate we are in debug mode)
- Shortcut: If we type "psvm" and hit enter on IntelliJ, it will automatically set up the main method

## Primitive Data Types:
- boolean - true/false value
- byte - 8-bit signed integer
- char - unicode character 'a', '1', '%'
- short - 16-bit signed integer
- int - 32-bit signed integer
- long - 64-bit signed integer
- float - 32-bit floating point
- double - 64-bit floating point

### Wrapper Classes
- As we know, primitives and classes are distinct
  - primitives are just basic values (numbers, characters, booleans)
  - Classes have fields, methods, have to be instantiated
- In some cases, we need to treat primitives as objects
  - For every primitive type, we have a corresponding class
    - int -> Integer
    - char -> Character

## Loops
- While Loops
  - take in a condition, the code will execute while that condition is true
    - Be mindful that we have to initialize our variables and increment "manually"
- For Loops
  - 3 parts to the declaration: for(init, condition, increment)
    - init - initialize any variable we need
    - condition - the condition by which the loop iterates
    - increment - what happens at the end of each loop

## Importing from other libraries
- Some functionalities in Java are taken from other libraries and packages such as Scanner and Date (both from java.util)

## Instantiating new objects
- When we see the "new" keyword, that means we are instantiating an object

## OOP - Object Oriented Programming
- Java is object-oriented
- We can create different classes and create instances from those classes
- 4 Pillars of OOP help us to adhere to best practices/standards
  - Abstraction - Hiding away the implementation details of methods
    - We can define the expected input/output/behavior, but we leave the implementation details to another class
    - In Java, we can achieve this in 2 ways:
      - Abstract Class - can have abstract methods (meaning no implementation details) and concrete methods ("normal" methods we've seen that have code in them)
      - Interface - we don't see any concrete methods, just the abstract method declarations
        - We can use the default keyword to include concrete methods in an interface
        - We will make use of interfaces when creating DAOs (Data Access Objects)
  - Inheritance - Parent-Child relationship where fields and method behaviors can be inherited from parent class
    - Example: Animal -> Mammal -> Dog
    - Can also override methods that are inherited if we need to switch up the functionality
      - Child can expand on the functionality of the parent
      - Open for extension, closed for modification (can't change what the parent does but the child can expand on those functionalities)
    - Types of Inheritance
      - Single - One parent and one child
      - Multilevel - Linear family tree, one child class inherits from one class which inherits from another
      - Hierarchical - one parent with many children inheriting from it
      - Multiple (NOT ALLOWED IN JAVA with classes) - one class inherits from multiple parents
      - Hybrid (NOT ALLOWED IN JAVA with classes) - combination of Multiple and Hierarchical
      - Multiple and Hybrid are achievable through interfaces
      - Rule of Thumb - One class cannot inherit multiple classes
    - "Super" keyword - used to access different aspects of the parent class
      - We can use it to access the constructor of the parent class
        - super();
      - We can also access/invoke methods from the parent class
        - super.methodName();
      - We can use it to access fields from the parent class
        - super.fieldName;
  - Encapsulation - Packaging everything about an object into a singular unit
    - The fields themselves are hidden (In Java, we use "private" keyword)
    - But, we still have public methods (getters and setters) that provide access
  - Polymorphism - Many forms
    - override - from Inheritance, multiple methods have different implementations (one for the child parent, one for parent)
    - overload - same name, different parameters
      - 2 methods with the same name in the same class but either type/order/number of parameters
        - public int add(int a, int b);
        - public int add(int a, int b, int c);
  
## Methods
- Used to perform some action
- Name - name of the method
- Output Type - what type of value will be returned
  - void - if nothing is returned
- Parameters - what is inputted to the method (define what the types will be)
  - When we invoke the method, we just need to make sure that the values that are passed in match the type of the 
  - parameters that were defined in the method
- Body - the code that will be executed
  - should be returning a value if the return type is not void
  
## Constructors
- Special methods that help us construct/create new instances of the class we have defined
- In Java, constructors take the same name of the class
- We can also have multiple different constructors as long as they have different parameters (overloading)
- A constructor is responsible for initializing the object, usually by setting values for the different fields
- If we don't have any constructor defined for a class, Java will create one for us (no arguments and doesn't really do much)



## Operators
- Math: +, -, *, /, %
- Boolean Operators:
  - ! - not
  - && - and
  - || - or
- Comparison
  - == checking if 2 references are the same

## Arrays
- Let us store multiple values in a predefined structure
  - We allocate the space that we need ahead of time
- int[] grades = new int[] {90,90,80,75,100};
- String [] foods = new String[5];
- Arrays.toString(array) => convert to a string

## Variable Scopes:
- We can define variables for different scopes in which they can be used
- Method Scope - defined within a method
- Instance Scope - fields that are scoped to the class instance
- Static Scope - fields can be scoped to the class overall
- Block Scope - defined in their designated "block" (for loops, if statements)

## Modifiers

### Access Modifiers
- private - can be applied to a method or a field - cannot be accessed from any other class
- public - can be accessed from anywhere in the project
  - public methods can be invoked from anywhere
  - public fields can be accessed anywhere
  - We usually make our classes public because we usually want our classes to be accessible from anywhere
- default (package) - can be accessed from anywhere within the package
  - Not to be confused with the "default" keyword to make concrete methods in an interface
  - when we give an entity (field, class, method) the default access, we don't actually type out "default", just leave it blank
- protected - can be accessed either
  - in the same package
  - any child class

### Non-Access Modifiers
- static - is we use this keyword, it will scope the variable/method to the class rather than the instance
  - Methods:
    - static method can be invoked from class or an object
    - non-static method can only be called from an instantiated object
    - We typically use static methods/fields when we're not dealing with state
  - Fields:
    - Attached to the class
    - Only useful if the value is the same across the entire class
  - The "static" keyword is place in front of methods and variables to make them static
  - From a non-static context can access both static and non-static fields/methods
  - From a static context, can ONLY access static fields/methods
- final
  - Final variables cannot be re-assigned
- abstract

