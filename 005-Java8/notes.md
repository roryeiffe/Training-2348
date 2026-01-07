## Java 8
- A lot of the features we'll talk about in Java 8 don't necessarily provide new functionality but provide "cleaner" ways of performing operations
- IntelliJ, we have to set our language level to 8 or higher
  - File -> Project Structure -> Project
  - Click on the drop-down menu Language Level and select anything 8 or higher

### Lambda Expressions
- Includes parameters and some expression
#### Variations
- parameter -> expression
  - take in a single parameter and return a value (whatever the expression evaluates to)
- (parameter1, parameter2, ...) -> expression
  - take in multiple parameters and return a value
- (parameter1, parameter2, ...) -> {code}
  - Takes in 1 or more parameters, and instead of evaluating a single expression, it runs the block of code
- Lamba Expressions are similar to methods in that they represent some input/output/code but they aren't really useful on their own until we look into Functional Interfaces
### Functional Interfaces
- An interface with a single abstract method
- We can use Functional Interfaces to store lambda expressions
- Built-In Functional Interfaces
  - Consumer - takes in a single value and doesn't return anything
    - take in a value and print it out
  - Predicate - takes in a single value and returns a boolean
    - check if a number is even
  - Function - take in a single value and return a single value
    - square/cube function
  - Supplier - not take in a value but will return a value
    - return a random number
  - Bi-versions of the first 3:
    - BiConsumer - takes in 2 values, returns nothing
    - BiPredicate - takes in 2 values, returns a boolean
    - BiFunction - takes in 2 values, returns a value
### Streams
- Streams help us process data from collections in Java
- We can perform many operations on a collection with simplified syntax using streams
- Intermediate Operations - used to manipulate/re-order the collection of data
  - map -> apply some function to every element in the collection
  - filter -> filtering out the elements based on some condition
  - sorted -> sort the elements
- Terminal Operations - the operations that take place after the intermediate options
  - collect - take all the return values from the stream and place it some Collection object
  - forEach - apply some function/operation to each object
  - reduce - reduce all elements into a single value
    - sum of the elements, maximum, count

### Method References
- Shorthand syntax for a lambda expression
- Use it reference a method and can be integrated well with Funtional Interfaces
  - Syntax (assuming we have a method called "print" in our "Main" class:
    ```java
    numbers.stream().forEach(Main::print);
    ```

### Optional Class
- Container Object that may or may not contain a non-null value
- Useful for situations where we might not have a value (ex: querying from a database)
- Contains methods to check if the value is there before using the value
  - This will help to prevent exceptions 